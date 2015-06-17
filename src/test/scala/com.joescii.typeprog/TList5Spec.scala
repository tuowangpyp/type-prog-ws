package com.joescii.typeprog

object TList5Spec {
  // You could park these in a companion object
  type NTNil = TNil[Nat]
  type :+:[H <: Nat, T <: TypeList[Nat]] = ::[Nat, H, T]
  type BTNil = TNil[Bool]
  type :|:[H <: Bool, T <: TypeList[Bool]] = ::[Bool, H, T]


  // Now TypeList works with Bool
  type List1 = False :|: True :|: False :|: False :|: BTNil
  type List2 = False :|: False :|: False :|: False :|: BTNil
  type List3 = True :|: True :|: True :|: BTNil

  implicitly[List1#size =:= List2#size]

  type Or = {type F[a <: Bool, b <: Bool] = a#Or[b]}
  type And = {type F[a <: Bool, b <: Bool] = a#And[b]}

  implicitly[List1#fold[False, Or#F] =:= True]
  implicitly[List2#fold[False, Or#F] =:= False]
  implicitly[List3#fold[False, Or#F] =:= True]
  implicitly[List1#fold[True, And#F] =:= False]
  implicitly[List2#fold[True, And#F] =:= False]
  implicitly[List3#fold[True, And#F] =:= True]


  // TypeList still works great with Nat
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]
  type Nat4 = NatN[Nat3]
  type Nat6 = NatN[NatN[Nat4]]

  type List4 = Nat0 :+: Nat1 :+: Nat2 :+: NTNil
  type List5 = Nat1 :+: Nat2 :+: Nat3 :+: NTNil
  type List6 = Nat2 :+: Nat3 :+: Nat4 :+: NTNil

  implicitly[List4#size =:= List5#size]
  implicitly[List4#map[({type F[i <: Nat] = NatN[i]})#F] =:= List5]
  implicitly[List4#map[({type F[i <: Nat] = NatN[NatN[i]]})#F] =:= List6]
  implicitly[List4#map[({type F[i <: Nat] = i#plus[Nat2]})#F]  =:= List6]

  type List7 = Nat2 :+: Nat1 :+: Nat0 :+: Nat1 :+: NTNil
  implicitly[List7#fold[Nat0, ({type F[a <: Nat, b <: Nat] = a#plus[b]})#F] =:= Nat4]

  type List8 = Nat1 :+: Nat1 :+: Nat3 :+: Nat2 :+: Nat1 :+: NTNil
  implicitly[List8#fold[Nat1, ({type F[a <: Nat, b <: Nat] = a#times[b]})#F] =:= Nat6]
}
