package io.github.ktecs.gl.components

import io.github.ktecs.Component
import io.github.ktecs.ECS
import io.github.ktecs.Entity
import io.github.ktecs.gl.math.Mat4f

data class Camera(val projection: Mat4f)

/**
 * Entity's camera component.
 */
@ECS
var Entity.camera : Camera? by Component()
