package com.joescii.typeprog

import org.scalatest.{ FlatSpec, Matchers }

class Vect1Specs extends FlatSpec with Matchers {
  "Vector addition" should "compute [1, 2] + [3, 4] => [4, 6]" in {
    val sum = (1 :: 2 :: VNil) + (3 :: 4 :: VNil)
    sum should equal(4 :: 6 :: VNil)
  }

  "Vector addition" should "reject [1, 2] + [5] with an IllegalArgumentException" in {
    intercept[IllegalArgumentException](
      (1 :: 2 :: VNil) + (5 :: VNil)
    )
  }
}
