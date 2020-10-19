---
layout: home
title: About
nav_order: 1
---

# Ktecs

Ktecs ("k-tex") is an entity component system (ECS) multiplatform library for Kotlin. It aims to be lightweight, general-purpose, easy to use, and Kotlin-idiomatic.

**Disclaimer:** Ktecs is experimental, and not yet ready for production use.

### Usage

Ktecs offers imperative and declarative styles.

#### Imperative

```kotlin
val myWorld = World()

val entity = myWorld.createEntity()
entity.setComponent(Transform(position = Vec3f(z = -10f)))
entity.setComponent(Spin(value = Vec3f(-0.01f, -0.01f, -0.01f)))

with(myWorld) {
  spin()
  render()
}
```

#### Declarative (DSL)

```kotlin
val myWorld = world {
  entity {
    transform = Transform(position = Vec3f(z = -10f))
    spin = Spin(value = Vec3f(-0.01f, -0.01f, -0.01f))
  }
}

with (myWorld) {
  spin()
  render()
}
```

### License

Ktecs is open source under the [MIT license](https://github.com/tschie/ktecs/blob/master/LICENSE).
