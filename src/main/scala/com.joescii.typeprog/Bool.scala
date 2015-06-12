package com.joescii.typeprog

sealed trait Bool {
  type Not <: Bool
  type Or[That <: Bool] <: Bool
}
sealed trait True extends Bool {
  type Not = False
  type Or[That <: Bool] = True
}
sealed trait False extends Bool {
  type Not = True
  type Or[That <: Bool] = That
}

