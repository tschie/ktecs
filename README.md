# Ktecs

Ktecs ("k-tex") is a simple entity component system (ECS) library written in Kotlin.

## Concepts

### Worlds

Worlds are containers for entities and their data.

Create a world:

```kotlin
val myWorld = World()

// Or use DSL
val myWorld = world {
  // ...
}
```

### Entities

Entities are just unique `Int` IDs. In Ktecs, entities also contain a reference to their world:

```kotlin
data class Entity(val id: Int, val world: World)
```

You must create them from a world:
```kotlin
val entity = world.createEntity()

// DSL
world {
  val e = entity {
    // ...
  }
  
  println(e.id) // 1
}
```

To remove:
```kotlin
world.removeEntity(entity)
```

### Components

Components are just data. You can use your own domain classes. It is recommended to use immutable data.

```kotlin
data class Transform(val position: Vec3f, val rotation: Vec3f, val scale: Vec3f)
data class Spin(val value: Vec3f)
```

Add the component to an entity:
```kotlin
entity.setComponent<Transform>(Transform())
// type can be inferred
entity.setComponent(Transform())
```

Retrieve the component:
```kotlin
val transform : Transform? = entity.getComponent<Transform>()
```

For less verbosity, a `Component` class is provided as a delegate for extension properties:
```kotlin
var Entity.transform : Transform? by Component()

val transform = entity.transform

// these are recommended when using the DSL:
world {
  entity {
    transform = Transform()
  }
}
```

### Systems

Systems are logic that operate on entities according to their components. 

Systems "query" worlds for entities having specific components:
```kotlin
val entities : List<Entity> = world.query(has<Transform>() and has<Spin>())
```

In Ktecs, system implementation is up to you. One option is to use extension functions:

```kotlin
fun World.spin(delta: Double) {
  query(has<Transform>() and has<Spin>()).forEach { entity ->
    val spin = entity.spin!!
    val transform = entity.transform!!
    val rotation = (transform.rotation + spin.value * delta.toFloat()) % (2f * PI.toFloat())
    entity.transform = transform.copy(rotation = rotation)
  }
}

fun animate(delta: Double, time: Double) {
  with (myWorld) {
    spin(delta)
    // other systems...
    // render
  }
  
  val now = now()
  animate(now - time, now)
}
```
