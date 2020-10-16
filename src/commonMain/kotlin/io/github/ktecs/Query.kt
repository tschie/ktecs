package io.github.ktecs

import kotlin.reflect.KClass

sealed class Query

data class Has<T: Any>(val componentClass: KClass<T>) : Query()
data class Not(val query: Query) : Query()
data class Or(val first: Query, val second: Query) : Query()
data class And(val first: Query, val second: Query) : Query()

inline fun <reified T: Any> has() = Has(T::class)

operator fun Has<*>.not() = Not(this)

infix fun Query.or(query: Query) = Or(this, query)

infix fun Query.and(query: Query) = And(this, query)
