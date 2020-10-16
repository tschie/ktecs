package io.github.ktecs

import kotlin.reflect.KProperty

/**
 * Delegate class for [Entity] component extension properties.
 *
 * Example:
 * ```
 * fun Entity.transform : Transform? by Component()
 * ```
 */
class Component {
  inline operator fun <reified T> getValue(thisRef: Entity, property: KProperty<*>) : T? {
    return thisRef.getComponent()
  }

  inline operator fun <reified T : Any> setValue(thisRef: Entity, property: KProperty<*>, value: T?) {
    if (value == null) {
      thisRef.removeComponent<T>()
    } else {
      thisRef.setComponent(value)
    }
  }
}
