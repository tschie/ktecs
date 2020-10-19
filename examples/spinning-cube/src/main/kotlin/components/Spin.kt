package components

import io.github.tschie.ktecs.Component
import io.github.tschie.ktecs.ECS
import io.github.tschie.ktecs.Entity
import io.github.tschie.ktecs.gl.math.Vec3f

data class Spin(val value: Vec3f = Vec3f())

/**
 * Entity's spin component.
 */
@ECS
var Entity.spin : Spin? by Component()

