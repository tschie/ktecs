import components.Spin
import components.fitCanvas
import components.perspectiveCamera
import components.spin
import data.cubeData
import data.fragmentShaderSource
import data.randomColors
import data.vertexShaderSource
import io.github.tschie.ktecs.Entity
import io.github.tschie.ktecs.World
import io.github.tschie.ktecs.entity
import io.github.tschie.ktecs.gl.components.*
import io.github.tschie.ktecs.gl.math.Vec3f
import io.github.tschie.ktecs.gl.systems.WebGLRenderer
import io.github.tschie.ktecs.gl.systems.render
import io.github.tschie.ktecs.world
import kotlinx.browser.document
import kotlinx.browser.window
import org.khronos.webgl.WebGLRenderingContext
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.events.Event
import systems.spin

lateinit var sandbox: World
lateinit var webGLRenderer: WebGLRenderer
lateinit var cube: Entity

fun main() {
  val canvas = document.querySelector("canvas") as HTMLCanvasElement

  // fill window
  window.addEventListener("resize", {
    canvas.width = window.innerWidth
    canvas.height = window.innerHeight
  })
  window.dispatchEvent(Event("resize"))

  val gl = canvas.getContext("webgl") as WebGLRenderingContext? ?: throw Error("WebGL not supported!")

  val sandbox = world {
    // camera
    entity {
      transform = Transform()
      camera = perspectiveCamera {
        fitCanvas(canvas)
      }
    }

    cube = entity {
      transform = Transform(position = Vec3f(z = -10.0f))
      mesh = Mesh(mapOf("position" to cubeData, "color" to randomColors(6, 3)))
      material = Material(vertexShaderSource, fragmentShaderSource)
      spin = Spin(value = Vec3f(0.001f, 0.001f, 0.001f))
    }
  }

  webGLRenderer = WebGLRenderer(gl)

  animate(0.0, window.performance.now())
}

fun animate(delta: Double, time: Double) {
  with (sandbox) {
    spin(delta)
    render(webGLRenderer)
  }

  val now = window.performance.now()
  window.requestAnimationFrame { animate(now - time, now) }
}
