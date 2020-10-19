package io.github.ktecs.gl.components

import io.github.ktecs.Component
import io.github.ktecs.ECS
import io.github.ktecs.Entity
import io.github.ktecs.gl.math.Vec3f

data class Transform(
    val position: Vec3f = Vec3f(),
    val rotation: Vec3f = Vec3f(),
    val scale: Vec3f = Vec3f(1.0f, 1.0f, 1.0f)
)

/**
 * Entity's transform component.
 */
@ECS
var Entity.transform : Transform? by Component()
