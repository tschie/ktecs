# Ktecs

Ktecs ("k-tex") is an entity component system (ECS) library for Kotlin.

**Disclaimer:** Ktecs is brand new, completely experimental, and not ready for production use at this time.

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

## Docs

For more information, view the [Docs](https://tschie.github.io/ktecs).

## Credits

Special thanks to these organizations for their projects that influenced and made this project possible. 

- Jetbrains, for creating Kotlin
- Mozilla Mixed Reality Team, for [ECSY](https://ecsy.io/) which Ktecs was inspired by

## Contributing

Ktecs is brand new and highly experimental at this point. As such, it is not yet open to external contributors. In the meantime, feel free to fork the repo, create libraries around it, or simply borrow the concepts in your own libraries if you think it has merit.

## License

Ktecs is open source under the [MIT License](LICENSE).
