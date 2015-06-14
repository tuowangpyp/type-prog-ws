package com.joescii.typeprog

import org.scalatest.{ FlatSpec, Matchers }

class Vect4Specs extends FlatSpec with Matchers {
  // Implement an apply method for random-access into the Vector
  "[4, 5, 6].apply(2)" should "return Some(6)" in {
    val v = (4 :: 5 :: 6 :: VNil)

    v(2) should equal (Some(6))
  }

  // We know this will not perform well for large Vectors.
  // Just because our Size type is recursively-defined does not mean our internal datastructure should be too.
  // Refactor NonEmptyVector to store values in an array.
}
