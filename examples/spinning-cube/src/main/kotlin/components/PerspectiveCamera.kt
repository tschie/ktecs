package components

import io.github.ktecs.ECS
import io.github.ktecs.gl.components.Camera
import io.github.ktecs.gl.math.Mat4f
import io.github.ktecs.gl.math.perspective
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit

/**
 * Adds a camera component to the entity with a perspective projection.
 */
@ECS
fun perspectiveCamera(aspect: Float = 1.0f, fov: Float = 70.0f, near: Float = 0.1f, far: Float = 1000.0f, init: Perspective.() -> Unit = {}) : Camera {
  val perspective = Perspective(aspect, fov, near, far)
  perspective.init()
  return Camera(perspective.projection)
}

/**
 * Configures a perspective's aspect ratio to the (possibly changing) dimensions of a canvas according to width / height.
 */
@ECS
fun Perspective.fitCanvas(canvas: HTMLCanvasElement) {
  this.aspect = canvas.width.toFloat() / canvas.height.toFloat()
  val observer = MutationObserver { _, _ ->
    this.aspect = canvas.width.toFloat() / canvas.height.toFloat()
  }
  observer.observe(canvas, MutationObserverInit(attributes = true, attributeFilter = arrayOf("width", "height")))
}

@ECS
class Perspective(aspect: Float, fov: Float, near: Float, far: Float) {

  var aspect = aspect
    set(value) {
      field = value
      update()
    }

  var fov = fov
    set(value) {
      field = value
      update()
    }

  var near = near
    set(value) {
      field = value
      update()
    }

  var far = far
    set(value) {
      field = value
      update()
    }

  var projection: Mat4f = matrix(); private set

  private fun matrix() : Mat4f {
    return perspective(aspect, fov, near, far)
  }

  private fun update() {
    matrix().elements.copyInto(projection.elements)
  }
}
