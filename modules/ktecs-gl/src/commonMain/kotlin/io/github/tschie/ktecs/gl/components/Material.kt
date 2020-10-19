package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.Component
import io.github.tschie.ktecs.Ktecs
import io.github.tschie.ktecs.Entity

data class Material(
    val vertexShaderSource: String,
    val fragmentShaderSource: String
)

/**
 * Entity's material component.
 */
@Ktecs
var Entity.material : Material? by Component()
