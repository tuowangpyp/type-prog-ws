package com.joescii.typeprog

import shapeless.test.illTyped

object Bool2Specs {
  implicitly[TrueType#And[TrueType] =:= TrueType]
  implicitly[TrueType#And[FalseType] =:= FalseType]
  implicitly[FalseType#And[TrueType] =:= FalseType]
  implicitly[FalseType#And[FalseType] =:= FalseType]

  illTyped("implicitly[TrueType#And[TrueType] =:= FalseType]")
  illTyped("implicitly[TrueType#And[FalseType] =:= TrueType]")
  illTyped("implicitly[FalseType#And[TrueType] =:= TrueType]")
  illTyped("implicitly[FalseType#And[FalseType] =:= TrueType]")

  // TODO: Di you implement And without touching TrueType or FalseType? It can be done :)
}
