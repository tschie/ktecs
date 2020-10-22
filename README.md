# Ktecs

Ktecs ("k-tex") is an **experimental** entity component system (ECS) library for Kotlin/JS.

## Install

Currently GitHub Package Registry for Maven does not support Kotlin multiplatform artifacts. They can be uploaded but not retrieved. In the meantime, the best option is to clone the repo and install each module to Maven local using the `publishToMavenLocal` Gradle task.

## Usage

```kotlin
val myWorld = world {
  // entities
  entity {
    // components
    transform = Transform(position = Vec3f(z = -10f))
    spin = Spin(value = Vec3f(xyz = -0.01f))
  }
}

with (myWorld) {
  // systems
  spin()
  render()
}
```

For more information, see the [Wiki](https://github.com/tschie/ktecs/wiki).

## Docs

[Kdoc on GitHub Pages](https://tschie.github.io/ktecs/index.html)

## Credits

Special thanks to these organizations for their projects that influenced and made this project possible. 

- Jetbrains, for creating Kotlin
- Mozilla Mixed Reality Team, for [ECSY](https://ecsy.io/) which Ktecs was inspired by

## License

Ktecs is open source under the [MIT License](LICENSE).
