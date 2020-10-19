package systems

import components.Spin
import components.spin
import io.github.ktecs.World
import io.github.ktecs.and
import io.github.ktecs.gl.components.Transform
import io.github.ktecs.gl.components.transform
import io.github.ktecs.gl.math.plus
import io.github.ktecs.gl.math.rem
import io.github.ktecs.gl.math.times
import io.github.ktecs.has
import kotlin.math.PI

fun World.spin(delta: Double) {
  query(has<Transform>() and has<Spin>()).forEach { entity ->
    val spin = entity.spin!!
    val transform = entity.transform!!
    val rotation = (transform.rotation + spin.value * delta.toFloat()) % (2f * PI.toFloat())
    entity.transform = transform.copy(rotation = rotation)
  }
}
