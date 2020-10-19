package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.core.Component
import io.github.tschie.ktecs.core.Ktecs
import io.github.tschie.ktecs.core.Entity

data class Mesh(val attributes: Map<String, Array<Array<Float>>>)

/**
 * Entity's mesh component.
 */
@Ktecs
var Entity.mesh : Mesh? by Component()
