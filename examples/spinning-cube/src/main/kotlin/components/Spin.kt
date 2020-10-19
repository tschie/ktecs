package components

import io.github.ktecs.Component
import io.github.ktecs.ECS
import io.github.ktecs.Entity
import io.github.ktecs.gl.math.Vec3f

data class Spin(val value: Vec3f = Vec3f())

/**
 * Entity's spin component.
 */
@ECS
var Entity.spin : Spin? by Component()

