package com.joescii.typeprog

import shapeless.test.illTyped

object Bool1Specs {
  implicitly[TrueType  =:= TrueType]
  implicitly[FalseType =:= FalseType]

  implicitly[TrueType#Not  =:= FalseType]
  implicitly[FalseType#Not =:= TrueType]

  implicitly[TrueType#Or[TrueType] =:= TrueType]
  implicitly[TrueType#Or[FalseType] =:= TrueType]
  implicitly[FalseType#Or[TrueType] =:= TrueType]
  implicitly[FalseType#Or[FalseType] =:= FalseType]

  illTyped("implicitly[TrueType  =:= FalseType]")
  illTyped("implicitly[FalseType =:= TrueType]")

  illTyped("implicitly[TrueType#Not  =:= TrueType]")
  illTyped("implicitly[FalseType#Not =:= FalseType]")

  illTyped("implicitly[TrueType#Or[TrueType] =:= FalseType]")
  illTyped("implicitly[TrueType#Or[FalseType] =:= FalseType]")
  illTyped("implicitly[FalseType#Or[TrueType] =:= FalseType]")
  illTyped("implicitly[FalseType#Or[FalseType] =:= TrueType]")
}
