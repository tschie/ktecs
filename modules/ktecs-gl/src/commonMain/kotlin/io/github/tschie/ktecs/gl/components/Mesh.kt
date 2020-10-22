package io.github.tschie.ktecs.gl.components

import io.github.tschie.ktecs.core.Ktecs
import io.github.tschie.ktecs.core.component.Component
import io.github.tschie.ktecs.core.entity.Entity

/**
 * Describes a mesh via its attributes such as position, color, etc. Each attribute should be added as an entry with its name and an array of values per vertex.
 *
 * Example:
 * ```
 * val triangleData = arrayOf(
 *   arrayOf(0.5f, 0.5f, 0.5f),
 *   arrayOf(0.5f, -0.5f, 0.5f),
 *   arrayOf(-0.5f, 0.5f, 0.5f)
 * )
 * Mesh(mapOf("position" to triangleData))
 * ```
 */
data class Mesh(val attributes: Map<String, Array<Array<Float>>>)

/**
 * Entity's mesh component.
 */
@Ktecs
var Entity.mesh : Mesh? by Component()
