package com.joescii.typeprog

object TList3Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]
  type Nat4 = NatN[Nat3]

  type List1 = Nat0 :: Nat1 :: Nat2 :: TNil
  type List2 = Nat1 :: Nat2 :: Nat3 :: TNil
  type List3 = Nat2 :: Nat3 :: Nat4 :: TNil

  implicitly[List1#map[({type F[i <: Nat] = NatN[i]})#F] =:= List2]
  implicitly[List1#map[({type F[i <: Nat] = NatN[NatN[i]]})#F] =:= List3]
  implicitly[List1#map[({type F[i <: Nat] = i#plus[Nat2]})#F] =:= List3]
}
