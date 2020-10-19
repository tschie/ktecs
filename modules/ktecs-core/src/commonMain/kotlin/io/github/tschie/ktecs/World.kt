package io.github.tschie.ktecs

import kotlin.reflect.KClass

/**
 * Container for entities and their data. Entities must be created from an existing world.
 */
@Ktecs
class World {
  // TODO: atomic int
  /**
   * Increments for every new entity to serve as a unique ID.
   */
  private var entityCount = 0

  /**
   * Updated list of all entities in this world.
   */
  private val entities = mutableListOf<Entity>()

  /**
   * Entities to component values by component type.
   */
  private val components = mutableMapOf<KClass<*>, MutableMap<Entity, Any>>()

  /**
   * Creates an entity in this world.
   *
   * @return the new entity
   */
  fun createEntity(): Entity {
    val entity = Entity(entityCount++, this)
    entities.add(entity)
    return entity
  }

  /**
   * Removes an entity from this world.
   *
   * @return true if the entity was removed; false if the entity was not in the world.
   */
  fun removeEntity(entity: Entity) : Boolean {
    components.forEach {
      it.value.remove(entity)
    }
    return entities.remove(entity)
  }

  /**
   * Gets the component of the given type for the specified entity.
   *
   * @param entity entity to get the component from
   * @param componentClass class of component to get
   * @return value of the requested component or null if the entity does not have a component of that type
   */
  fun <K: Any> getComponent(entity: Entity, componentClass: KClass<K>) : K? {
    @Suppress("UNCHECKED_CAST")
    return components[componentClass]?.get(entity) as K?
  }

  /**
   * Sets the component by its type for the specified entity.
   *
   * @param entity entity to set component on
   * @param componentData component to set on the entity
   */
  fun <K: Any> setComponent(entity: Entity, componentData: K) : K {
    val component = components[componentData::class]
    if (component != null) {
      component[entity] = componentData
    } else {
      components[componentData::class] = mutableMapOf(entity to componentData)
    }
    return componentData
  }

  /**
   * Removes the component of the given type for the specified entity.
   *
   * @param entity entity to remove component from
   * @param componentClass class of component to remove
   * @return value of the removed component or null if the entity did not have the component
   */
  fun <K : Any> removeComponent(entity: Entity, componentClass: KClass<K>) : K? {
    val component = components[componentClass]
    @Suppress("UNCHECKED_CAST")
    return component?.remove(entity) as K?
  }

  /**
   * Finds all entities matching the criteria of the given query.
   *
   * @param query Query to match entities against
   * @return entities matching the given query
   */
  fun query(query: Query) : List<Entity> {
    return when (query) {
      is Has<*> -> {
        entities.filter { this.getComponent(it, query.componentClass) != null }
      }
      is Or -> {
        query(query.first).union(query(query.second)).toSet().toList()
      }
      is And -> {
        query(query.first).intersect(query(query.second)).toSet().toList()
      }
      is Not -> {
        when (query.query) {
          is Has<*> -> {
            entities.filter { this.getComponent(it, query.query.componentClass) == null }
          }
          is Or -> {
            query(And(Not(query.query.first), Not(query.query.second)))
          }
          is And -> {
            query(Or(Not(query.query.first), Not(query.query.second)))
          }
          is Not -> {
            // cancel out negations
            query(query.query.query)
          }
        }
      }
    }
  }
}

/**
 * Initializes a new world.
 *
 * @param init function to initialize world
 * @return the new world
 */
@Ktecs
fun world(init: World.() -> Unit) : World {
  val world = World()
  world.init()
  return world
}
