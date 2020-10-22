package io.github.tschie.ktecs.core.query

import kotlin.reflect.KClass

/**
 * Class all Ktecs queries extend from.
 */
sealed class Query

/**
 * Query for entities having the specified component.
 *
 * @param componentClass component type
 */
data class Has<T: Any>(val componentClass: KClass<T>) : Query()

/**
 * Query for the complement of the specified query.
 */
data class Not(val query: Query) : Query()

/**
 * Query for the union of two queries.
 */
data class Or(val first: Query, val second: Query) : Query()

/**
 * Query for the intersection of two queries.
 */
data class And(val first: Query, val second: Query) : Query()

/**
 * Creates a query for entities having the specified type.
 */
inline fun <reified T: Any> has() = Has(T::class)

/**
 * Creates a query which should return the complement of this query.
 */
operator fun Query.not() = Not(this)

/**
 * Creates a query for the union of this query and the specified query.
 */
infix fun Query.or(query: Query) = Or(this, query)

/**
 * Creates a query for the intersection of this query and the specified query.
 */
infix fun Query.and(query: Query) = And(this, query)
