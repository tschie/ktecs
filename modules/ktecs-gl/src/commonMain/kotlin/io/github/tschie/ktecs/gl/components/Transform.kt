package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.Component
import io.github.tschie.ktecs.Ktecs
import io.github.tschie.ktecs.Entity
import io.github.tschie.ktecs.gl.math.Vec3f

data class Transform(
    val position: Vec3f = Vec3f(),
    val rotation: Vec3f = Vec3f(),
    val scale: Vec3f = Vec3f(1.0f, 1.0f, 1.0f)
)

/**
 * Entity's transform component.
 */
@Ktecs
var Entity.transform : Transform? by Component()
