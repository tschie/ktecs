package components

import io.github.tschie.ktecs.core.Ktecs
import io.github.tschie.ktecs.core.component.Component
import io.github.tschie.ktecs.core.entity.Entity
import io.github.tschie.ktecs.gl.math.Vec3f

data class Spin(val value: Vec3f = Vec3f())

/**
 * Entity's spin component.
 */
@Ktecs
var Entity.spin : Spin? by Component()

