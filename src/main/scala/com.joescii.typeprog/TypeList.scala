package com.joescii.typeprog

sealed trait TypeList {
  type size <: Nat
}
sealed trait TNil extends TypeList {
  type size = Nat0
}
sealed trait ::[H, T <: TypeList] extends TypeList {
  type size = NatN[T#size]
}