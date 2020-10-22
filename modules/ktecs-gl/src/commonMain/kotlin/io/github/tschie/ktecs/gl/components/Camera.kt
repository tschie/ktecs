package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.core.Ktecs
import io.github.tschie.ktecs.core.component.Component
import io.github.tschie.ktecs.core.entity.Entity
import io.github.tschie.ktecs.gl.math.Mat4f

/**
 * Describes a 3D camera by a 4x4 projection matrix.
 */
data class Camera(val projection: Mat4f)

/**
 * Entity's camera component.
 */
@Ktecs
var Entity.camera : Camera? by Component()
