package com.joescii.typeprog

sealed trait Nat {
  type plus[That <: Nat] <: Nat
}
sealed trait Nat0 extends Nat {
  type plus[That <: Nat] = That
}
sealed trait NatN[Prev <: Nat] extends Nat {
  type plus[That <: Nat] = NatN[Prev#plus[That]]
}

object Nat {
  type +[A <: Nat, B <: Nat] = A#plus[B]
}
