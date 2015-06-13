package com.joescii.typeprog

import org.scalatest.{ FlatSpec, Matchers }

class Vect1Specs extends FlatSpec with Matchers {
  val sum = (1 :: 2 :: VNil) + (3 :: 4 :: VNil)
  sum should equal (4 :: 6 :: VNil)

  intercept[IllegalArgumentException](
    (1 :: 2 :: VNil) + (5 :: VNil)
  )
}
