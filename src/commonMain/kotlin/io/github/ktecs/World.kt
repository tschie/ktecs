package io.github.ktecs

import kotlin.reflect.KClass

/**
 *
 */
@ECS
class World {
  // TODO: atomic int
  private var entityCount = 0
  private val entities = mutableListOf<Entity>()
  private val components = mutableMapOf<KClass<*>, MutableMap<Entity, Any>>()

  fun createEntity(): Entity {
    val entity = Entity(entityCount++, this)
    entities.add(entity)
    return entity
  }

  fun removeEntity(entity: Entity) {
    entities.remove(entity)
    components.forEach {
      it.value.remove(entity)
    }
  }

  fun <K: Any> getComponent(entity: Entity, componentClass: KClass<K>) : K? {
    @Suppress("UNCHECKED_CAST")
    return components[componentClass]?.get(entity) as K?
  }

  fun <K: Any> setComponent(entity: Entity, componentData: K) : K {
    val component = components[componentData::class]
    if (component != null) {
      component[entity] = componentData
    } else {
      components[componentData::class] = mutableMapOf(entity to componentData)
    }
    return componentData
  }

  fun <K : Any> removeComponent(entity: Entity, componentClass: KClass<K>) : K? {
    val component = components[componentClass]
    @Suppress("UNCHECKED_CAST")
    return component?.remove(entity) as K?
  }

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
 */
@ECS
fun world(init: World.() -> Unit) : World {
  val world = World()
  world.init()
  return world
}
