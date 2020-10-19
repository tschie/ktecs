package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.Component
import io.github.tschie.ktecs.ECS
import io.github.tschie.ktecs.Entity
import io.github.tschie.ktecs.gl.math.Mat4f

data class Camera(val projection: Mat4f)

/**
 * Entity's camera component.
 */
@ECS
var Entity.camera : Camera? by Component()
