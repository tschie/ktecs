package io.github.ktecs.gl.components

import io.github.ktecs.Component
import io.github.ktecs.ECS
import io.github.ktecs.Entity

data class Mesh(val attributes: Map<String, Array<Array<Float>>>)

/**
 * Entity's mesh component.
 */
@ECS
var Entity.mesh : Mesh? by Component()
