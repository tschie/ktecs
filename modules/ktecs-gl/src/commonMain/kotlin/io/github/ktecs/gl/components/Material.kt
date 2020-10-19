package io.github.ktecs.gl.components

import io.github.ktecs.Component
import io.github.ktecs.ECS
import io.github.ktecs.Entity

data class Material(
    val vertexShaderSource: String,
    val fragmentShaderSource: String
)

/**
 * Entity's material component.
 */
@ECS
var Entity.material : Material? by Component()
