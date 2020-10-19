package io.github.tschie.ktecs.core

/**
 * A unique ID that can be associated with data. Entity's are unique in the [World] they exist in. Entities must be created from a world.
 *
 * @property id entity's unique ID
 * @property world the world the entity exists within
 */
@Ktecs
data class Entity internal constructor(val id: Int, val world: World) {

    /**
     * Checks if the entity has a component with the given type.
     *
     * @param T type of the component
     * @return true if entity has a component of the given type; false otherwise
     */
    inline fun <reified T: Any> hasComponent() : Boolean {
        return getComponent<T>() != null
    }

    /**
     * Gets the entity's component of the given type.
     *
     * @param T type of the component
     * @return the value of the entity's component or null if the entity does not have the component
     */
    inline fun <reified T: Any> getComponent() : T? {
        return world.getComponent(this, T::class)
    }

    /**
     * Sets the value of the entity's component of the given type.
     *
     * @param T type of the component
     * @param value value of the component to set
     */
    inline fun <reified T: Any> setComponent(value: T) : T? {
        return world.setComponent(this, value)
    }

    /**
     * Removes the entity's component of the given type.
     *
     * @param T type of the component
     * @return true if a component of the given type was removed; false if the entity did not have the component
     */
    inline fun <reified T: Any> removeComponent() : T? {
        return world.removeComponent(this, T::class)
    }
}

/**
 * Creates an entity in this world.
 *
 * @param init function to initialize the entity
 * @return the new entity
 */
@Ktecs
fun World.entity(init: Entity.() -> Unit = {}) : Entity {
    val entity = createEntity()
    entity.init()
    return entity
}
