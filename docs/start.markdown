---
layout: page
title: Getting Started
permalink: /getting-started/
nav_order: 2
---

# Getting Started

### Kotlin/Common (Library)

```kotlin
val commonMain by getting {
  dependencies {
    implementation("io.github.ktecs:ktecs:1.0-SNAPSHOT")
  }
}
```

It is sufficient to just include the multiplatform library in the common dependencies to make it available to all platform source sets.

### Kotlin/JS

```kotlin
dependencies {
  implementation("io.github.ktecs:ktecs-js:1.0-SNAPSHOT")
}
```

### Kotlin/JVM

```kotlin
dependencies {
  implementation("io.github.ktecs:ktecs-jvm:1.0-SNAPSHOT")
}
```

### Kotlin/Native

TODO
