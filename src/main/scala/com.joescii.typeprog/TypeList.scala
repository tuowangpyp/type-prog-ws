package com.joescii.typeprog

sealed trait TypeList {
  type size <: Nat
  type reduce <: Nat
}
sealed trait TNil extends TypeList {
  type size = Nat0
  type reduce = Nat0
}
sealed trait ::[H <: Nat, T <: TypeList] extends TypeList {
  type size = NatN[T#size]
  type reduce = H#plus[T#reduce]
}