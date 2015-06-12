package com.joescii.typeprog

object Nat3Specs {
  // Can you generate a Nat so large that it breaks the compiler?
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]

  implicitly[Nat2 =:= Nat2#exp[Nat2#exp[Nat2#exp[Nat2#exp[Nat2]]]]]
}
