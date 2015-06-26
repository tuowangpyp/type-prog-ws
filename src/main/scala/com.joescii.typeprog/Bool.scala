package com.joescii.typeprog

sealed trait Bool {
  type Not <: Bool
  type Or[That <: Bool] <: Bool
  type And[That <: Bool] <: Bool
  type Imp[That <: Bool] <: Bool
}
sealed trait True extends Bool {
  type Not = False
  type Or[That <: Bool] = True
  type And[That <: Bool] = That
  type Imp[That <: Bool] = That
}
sealed trait False extends Bool {
  type Not = True
  type Or[That <: Bool] = That
  type And[That <: Bool] = False
  type Imp[That <: Bool] = True
}

