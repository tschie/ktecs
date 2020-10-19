# Ktecs

Ktecs ("k-tex") is an **experimental** entity component system (ECS) library for Kotlin/JS.

## Usage

```kotlin
val myWorld = world {
  // entities
  entity {
    // components
    transform = Transform(position = Vec3f(z = -10f))
    spin = Spin(value = Vec3f(-0.01f, -0.01f, -0.01f))
  }
}

with (myWorld) {
  // systems
  spin()
  render()
}
```

For more information, see the [Wiki](https://github.com/tschie/ktecs/wiki).

## Credits

Special thanks to these organizations for their projects that influenced and made this project possible. 

- Jetbrains, for creating Kotlin
- Mozilla Mixed Reality Team, for [ECSY](https://ecsy.io/) which Ktecs was inspired by

## License

Ktecs is open source under the [MIT License](LICENSE).
