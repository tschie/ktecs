package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.core.Ktecs
import io.github.tschie.ktecs.core.component.Component
import io.github.tschie.ktecs.core.entity.Entity
import io.github.tschie.ktecs.gl.math.*

/**
 * Describes an object's position, rotation, and scale in space. Defaults to the origin, with no rotation, and a unit scale.
 *
 * @property position object's position in space
 * @property rotation object's rotation about its axis in degrees
 * @property scale object's scale
 */
data class Transform(
    val position: Vec3f = Vec3f(),
    val rotation: Vec3f = Vec3f(),
    val scale: Vec3f = Vec3f(1f)
)

/**
 * Entity's transform component.
 */
@Ktecs
var Entity.transform : Transform? by Component()
