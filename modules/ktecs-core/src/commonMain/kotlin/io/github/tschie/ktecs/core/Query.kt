package io.github.tschie.ktecs.core

import kotlin.reflect.KClass

/**
 * Class all query Ktecs queries extend from.
 */
sealed class Query

/**
 * Query representing true if an entity has the specified component by type.
 *
 * @param componentClass type of component the entity should have
 */
data class Has<T: Any>(val componentClass: KClass<T>) : Query()

/**
 * Query representing the negation of the specified query.
 */
data class Not(val query: Query) : Query()

/**
 * Query representing logical OR of the results of the two specified queries.
 */
data class Or(val first: Query, val second: Query) : Query()

/**
 * Query representing logical AND of the results of the two specified queries.
 */
data class And(val first: Query, val second: Query) : Query()

/**
 * Creates a query which should return an entity having a component of the specified type.
 */
inline fun <reified T: Any> has() = Has(T::class)

/**
 * Creates a query which should return the negation of this query.
 */
operator fun Query.not() = Not(this)

/**
 * Creates a query which should return the union of results from this query and the specified query.
 */
infix fun Query.or(query: Query) = Or(this, query)

/**
 * Creates a query which should return the intersection of results from this query and the specified query.
 */
infix fun Query.and(query: Query) = And(this, query)
