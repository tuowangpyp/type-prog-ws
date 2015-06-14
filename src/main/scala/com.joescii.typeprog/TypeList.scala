package com.joescii.typeprog

sealed trait TypeList {
  type size <: Nat
  type reduce <: Nat
  type map[F[_] <: Nat] <: TypeList
}
sealed trait TNil extends TypeList {
  type size = Nat0
  type reduce = Nat0
  type map[F[_] <: Nat] = TNil
}
sealed trait ::[H <: Nat, T <: TypeList] extends TypeList {
  type size = NatN[T#size]
  type reduce = H#plus[T#reduce]
  type map[F[_] <: Nat] = F[H] :: T#map[F]
}