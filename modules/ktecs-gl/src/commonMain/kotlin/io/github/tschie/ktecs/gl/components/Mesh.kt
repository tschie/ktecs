package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.Component
import io.github.tschie.ktecs.Ktecs
import io.github.tschie.ktecs.Entity

data class Mesh(val attributes: Map<String, Array<Array<Float>>>)

/**
 * Entity's mesh component.
 */
@Ktecs
var Entity.mesh : Mesh? by Component()
