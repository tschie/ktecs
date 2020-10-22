package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.core.Ktecs
import io.github.tschie.ktecs.core.component.Component
import io.github.tschie.ktecs.core.entity.Entity

/**
 * Describes a material by vertex and fragment shaders.
 *
 * @property vertexShaderSource vertex shader source code
 * @property fragmentShaderSource fragment shader source code
 */
data class Material(
    val vertexShaderSource: String,
    val fragmentShaderSource: String
)

/**
 * Entity's material component.
 */
@Ktecs
var Entity.material : Material? by Component()
