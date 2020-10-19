package io.github.ktecs.gl.math

data class Vec3f(val x: Float = 0.0f, val y: Float = 0.0f, val z: Float = 0.0f)

operator fun Vec3f.plus(v: Vec3f) : Vec3f {
  return Vec3f(x + v.x, y + v.y, z + v.z)
}

operator fun Vec3f.times(s: Float) : Vec3f {
  return Vec3f(x * s, y * s, z * s)
}

operator fun Vec3f.rem(s: Float) : Vec3f {
  return Vec3f(x % s, y % s, z % s)
}

fun Vec3f.toArray() : Array<Float> = arrayOf(this.x, this.y, this.z)
