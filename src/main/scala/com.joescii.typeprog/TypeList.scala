package com.joescii.typeprog

import Nat._

sealed trait TypeList {
  type size <: Nat
  type reduce <: Nat
  type map[F[_ <: Nat] <: Nat] <: TypeList
}
sealed trait TNil extends TypeList {
  type size = Nat0
  type reduce = Nat0
  type map[F[_ <: Nat] <: Nat] = TNil
}
sealed trait ::[H <: Nat, T <: TypeList] extends TypeList {
  type size = NatN[T#size]
  type reduce = H + (T#reduce)
  type map[F[_ <: Nat] <: Nat] = F[H] :: T#map[F]
}

object TypeList {
  type map[T <: TypeList, F[_ <: Nat] <: Nat] = T#map[F]
}