package systems

import components.Spin
import components.spin
import io.github.tschie.ktecs.core.query.and
import io.github.tschie.ktecs.core.query.has
import io.github.tschie.ktecs.core.world.World
import io.github.tschie.ktecs.gl.components.Transform
import io.github.tschie.ktecs.gl.components.transform
import io.github.tschie.ktecs.gl.math.plus
import io.github.tschie.ktecs.gl.math.rem
import io.github.tschie.ktecs.gl.math.times

fun World.spin(delta: Double) {
  query(has<Transform>() and has<Spin>()).forEach { entity ->
    val spin = entity.spin!!
    val transform = entity.transform!!
    val rotation = transform.rotation + (spin.value * delta.toFloat()) % 360f
    entity.transform = transform.copy(rotation = rotation)
  }
}
