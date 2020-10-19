package data

import kotlin.random.Random

fun randomColors(faces: Int, dimension: Int) : Array<Array<Float>> {
  val colors = mutableListOf<Array<Float>>()
  for (i in 1..faces) {
    val color = (1..dimension).map { Random.nextFloat() }.toTypedArray()
    for (j in 1..faces) {
      colors.add(color)
    }
  }
  return colors.toTypedArray()
}
