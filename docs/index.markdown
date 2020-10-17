---
layout: home
---

# Ktecs

Ktecs ("k-tex") is an entity component system (ECS) multiplatform library for Kotlin. It aims to be lightweight, general-purpose, easy to use, and Kotlin-idiomatic.

**Disclaimer:** Ktecs is brand new, completely experimental, and not ready for production use at this time.

### Install

```groovy
dependencies {
  implementation("io.github.ktecs:ktecs:1.0-SNAPSHOT")
}
```

See the [Getting Started](getting-started) page for platform-specific dependencies.

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

Ktecs is open source under the [MIT license](https://tschie.github.io/ktecs/blob/master/LICENSE).
