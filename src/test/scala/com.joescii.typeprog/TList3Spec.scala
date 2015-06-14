package com.joescii.typeprog

object TList3Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]

  type List1  = Nat0 :: Nat1 :: Nat1 :: TNil
  type List2  = Nat1 :: Nat2 :: Nat0 :: TNil
  type ZipSum = Nat1 :: Nat3 :: Nat1 :: TNil

  implicitly[List1#zipsum[List2] =:= ZipSum]
}
