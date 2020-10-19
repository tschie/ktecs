package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.core.Component
import io.github.tschie.ktecs.core.Ktecs
import io.github.tschie.ktecs.core.Entity

data class Material(
    val vertexShaderSource: String,
    val fragmentShaderSource: String
)

/**
 * Entity's material component.
 */
@Ktecs
var Entity.material : Material? by Component()
