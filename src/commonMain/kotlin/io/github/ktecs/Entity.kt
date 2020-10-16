package io.github.ktecs

@ECS
data class Entity internal constructor(val id: Int, val world: World) {

    /**
     * Checks if the entity has a component with the given type.
     */
    inline fun <reified K: Any> hasComponent() : Boolean {
        return getComponent<K>() != null
    }

    /**
     * Gets the entity's component of the given type.
     *
     * @return the value of the entity's component or null if the entity does not have the component
     */
    inline fun <reified K: Any> getComponent() : K? {
        return world.getComponent(this, K::class)
    }

    /**
     * Sets the value of the entity's component of the given type.
     */
    inline fun <reified K: Any> setComponent(data: K) : K? {
        return world.setComponent(this, data)
    }

    /**
     * Removes the entity's component of the given type.
     */
    inline fun <reified K: Any> removeComponent() : K? {
        return world.removeComponent(this, K::class)
    }
}

@ECS
fun World.entity(init: Entity.() -> Unit = {}) : Entity {
    val entity = createEntity()
    entity.init()
    return entity
}
