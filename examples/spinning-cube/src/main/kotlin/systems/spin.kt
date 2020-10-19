package systems

import components.Spin
import components.spin
import io.github.tschie.ktecs.World
import io.github.tschie.ktecs.and
import io.github.tschie.ktecs.gl.components.Transform
import io.github.tschie.ktecs.gl.components.transform
import io.github.tschie.ktecs.gl.math.plus
import io.github.tschie.ktecs.gl.math.rem
import io.github.tschie.ktecs.gl.math.times
import io.github.tschie.ktecs.has
import kotlin.math.PI

fun World.spin(delta: Double) {
  query(has<Transform>() and has<Spin>()).forEach { entity ->
    val spin = entity.spin!!
    val transform = entity.transform!!
    val rotation = (transform.rotation + spin.value * delta.toFloat()) % (2f * PI.toFloat())
    entity.transform = transform.copy(rotation = rotation)
  }
}
