package io.github.tschie.ktecs.gl.systems

import io.github.tschie.ktecs.core.query.and
import io.github.tschie.ktecs.core.query.has
import io.github.tschie.ktecs.core.world.World
import io.github.tschie.ktecs.gl.components.*
import io.github.tschie.ktecs.gl.math.*
import org.khronos.webgl.Float32Array
import org.khronos.webgl.WebGLBuffer
import org.khronos.webgl.WebGLProgram
import org.khronos.webgl.WebGLRenderingContext

typealias Attribute = Map.Entry<String, Array<Array<Float>>>

/**
 * A renderer for keeping track of objects related to a WebGLRenderingContext.
 */
class WebGLRenderer(val gl: WebGLRenderingContext) {
  val materialPrograms = mutableMapOf<Material, WebGLProgram?>()
  val attributeBuffers = mutableMapOf<Attribute, WebGLBuffer?>()

  init {
    gl.enable(WebGLRenderingContext.DEPTH_TEST)
  }
}

// TODO: move inside WebGLRenderer when multiple receivers are supported
/**
 * Renders all renderable entities (having transform, mesh, and material components) using every camera entity (having transform and camera components) using the specified WebGL renderer.
 *
 * @receiver world to query entities on for rendering
 * @param webGLRenderer WebGL Renderer with the WebGL context to use for rendering
 */
fun World.render(webGLRenderer: WebGLRenderer) {
  // clear canvas
  webGLRenderer.gl.viewport(0, 0, webGLRenderer.gl.canvas.width, webGLRenderer.gl.canvas.height)
  webGLRenderer.gl.clearColor(0f, 0f, 0f, 0f)
  webGLRenderer.gl.clear(WebGLRenderingContext.COLOR_BUFFER_BIT)

  // draw entities with each camera
  query(has<Camera>() and has<Transform>()).forEach { cameraEntity ->
    val cameraTransform = cameraEntity.transform!!
    val camera = cameraEntity.camera!!

    val cameraMatrix = cameraTransform.toMatrix()

    val projectionMatrix = camera.projection
    val viewMatrix = cameraMatrix.inverse()
    val viewProjectionMatrix = projectionMatrix * viewMatrix

    query(has<Transform>() and has<Mesh>() and has<Material>()).forEach { entity ->
      val material = entity.material!!
      val mesh = entity.mesh!!
      val transform = entity.transform!!

      // use material program
      val program = webGLRenderer.materialPrograms.getOrPut(material) {
        val vertShader = webGLRenderer.gl.createShader(WebGLRenderingContext.VERTEX_SHADER)
        webGLRenderer.gl.shaderSource(vertShader, material.vertexShaderSource)
        webGLRenderer.gl.compileShader(vertShader)

        val fragShader = webGLRenderer.gl.createShader(WebGLRenderingContext.FRAGMENT_SHADER)
        webGLRenderer.gl.shaderSource(fragShader, material.fragmentShaderSource)
        webGLRenderer.gl.compileShader(fragShader)

        val program = webGLRenderer.gl.createProgram()
        webGLRenderer.gl.attachShader(program, vertShader)
        webGLRenderer.gl.attachShader(program, fragShader)
        webGLRenderer.gl.linkProgram(program)

        program
      }
      webGLRenderer.gl.useProgram(program)

      // update transform uniform
      val transformationMatrix = transform.toMatrix()
      val positionMatrix = viewProjectionMatrix * transformationMatrix

      webGLRenderer.gl.getUniformLocation(program, "transform")?.let {
        webGLRenderer.gl.uniformMatrix4fv(it, false, transformationMatrix.elements.flatten().toTypedArray())
      }

      webGLRenderer.gl.getUniformLocation(program, "positionMatrix")?.let {
        webGLRenderer.gl.uniformMatrix4fv(it, false, positionMatrix.elements.flatten().toTypedArray())
      }

      // draw vertices
      mesh.attributes["position"]?.let { position ->
        mesh.attributes.forEach { attribute ->

          // TODO: check if attribute was changed
          val buffer = webGLRenderer.attributeBuffers.getOrPut(attribute) {
            val buffer = webGLRenderer.gl.createBuffer()
            webGLRenderer.gl.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, buffer)
            webGLRenderer.gl.bufferData(
              WebGLRenderingContext.ARRAY_BUFFER,
              Float32Array(attribute.value.flatten().toTypedArray()),
              WebGLRenderingContext.STATIC_DRAW
            )

            buffer
          }

          val attrLocation = webGLRenderer.gl.getAttribLocation(program, attribute.key)
          webGLRenderer.gl.enableVertexAttribArray(attrLocation)
          webGLRenderer.gl.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, buffer)
          webGLRenderer.gl.vertexAttribPointer(
            attrLocation,
            attribute.value.getOrNull(0)?.size ?: 0,
            WebGLRenderingContext.FLOAT,
            false,
            0,
            0
          )
        }

        webGLRenderer.gl.drawArrays(WebGLRenderingContext.TRIANGLES, 0, position.size)
      }
    }
  }
}


fun Transform.toMatrix() : Mat4f {
  return Mat4f((
    Mat4.fromRotationTranslationScale(
      Mat4.create() as Float32Array,
      Quat.fromEuler(
        Quat.create() as Float32Array,
        rotation.x,
        rotation.y,
        rotation.z
      ) as Float32Array,
      position.toArray(),
      scale.toArray()
    ) as Float32Array).toArray())
}
