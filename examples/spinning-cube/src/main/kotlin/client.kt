import components.Spin
import components.fitCanvas
import components.perspectiveCamera
import components.spin
import data.cubeData
import data.fragmentShaderSource
import data.randomColors
import data.vertexShaderSource
import io.github.tschie.ktecs.core.entity.entity
import io.github.tschie.ktecs.core.world.World
import io.github.tschie.ktecs.core.world.world
import io.github.tschie.ktecs.gl.components.*
import io.github.tschie.ktecs.gl.math.*
import io.github.tschie.ktecs.gl.systems.WebGLRenderer
import io.github.tschie.ktecs.gl.systems.render
import kotlinx.browser.document
import kotlinx.browser.window
import org.khronos.webgl.WebGLRenderingContext
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.events.Event
import systems.spin

lateinit var sandbox: World
lateinit var webGLRenderer: WebGLRenderer

fun main() {
  val canvas = document.querySelector("canvas") as HTMLCanvasElement

  // fill window
  window.addEventListener("resize", {
    canvas.width = window.innerWidth
    canvas.height = window.innerHeight
  })
  window.dispatchEvent(Event("resize"))

  val gl = canvas.getContext("webgl") as WebGLRenderingContext? ?: throw Error("WebGL not supported!")

  sandbox = world {
    // camera
    entity {
      transform = Transform()
      camera = perspectiveCamera {
        fitCanvas(canvas)
      }
    }

    // cube
    entity {
      transform = Transform(position = Vec3f(z = -10.0f))
      mesh = Mesh(mapOf("position" to cubeData, "color" to randomColors(6, 3)))
      material = Material(vertexShaderSource, fragmentShaderSource)
      spin = Spin(value = Vec3f(xyz = 0.003f))
    }
  }

  webGLRenderer = WebGLRenderer(gl)

  animate()
}

fun animate(delta: Double = 0.0, time: Double = window.performance.now()) {
  with (sandbox) {
    spin(delta)
    render(webGLRenderer)
  }

  val now = window.performance.now()
  window.requestAnimationFrame { animate(now - time, now) }
}
