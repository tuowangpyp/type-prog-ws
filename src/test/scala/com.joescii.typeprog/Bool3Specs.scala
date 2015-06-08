package com.joescii.typeprog

import shapeless.test.illTyped

object Bool3Specs {
  implicitly[TrueType#Imp[TrueType] =:= TrueType]
  implicitly[TrueType#Imp[FalseType] =:= FalseType]
  implicitly[FalseType#Imp[TrueType] =:= TrueType]
  implicitly[FalseType#Imp[FalseType] =:= TrueType]

  illTyped("implicitly[TrueType#Imp[TrueType] =:= FalseType]")
  illTyped("implicitly[TrueType#Imp[FalseType] =:= TrueType]")
  illTyped("implicitly[FalseType#Imp[TrueType] =:= FalseType]")
  illTyped("implicitly[FalseType#Imp[FalseType] =:= FalseType]")

  // TODO: Imp can also be implemented solely in BoolType.
}
