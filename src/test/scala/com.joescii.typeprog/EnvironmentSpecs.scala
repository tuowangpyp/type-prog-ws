package com.joescii.typeprog

import org.scalatest.{ FlatSpec, Matchers }

class EnvironmentSpecs extends FlatSpec with Matchers {
  "The successful test" should "be green" in {
    true should equal (true)
  }

  "The failing test" should "be red" in {
    "answer" should be (42)
    
  }
}
