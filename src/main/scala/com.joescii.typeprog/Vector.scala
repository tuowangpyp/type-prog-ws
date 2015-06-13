package com.joescii.typeprog

sealed trait Vector {
  def size:Int
  def ::(head:Int):Vector = NonEmptyVector(head, this)
  def +(that:Vector):Vector
}

case object VNil extends Vector  {
  val size = 0
  def +(that:Vector) = {
    require(that == this)
    VNil
  }
}

case class NonEmptyVector(head:Int, tail:Vector) extends Vector {
  val size = 1 + tail.size
  def +(that:Vector) = {
    require(that.size == this.size)
    that match {
      case NonEmptyVector(head2, tail2) => NonEmptyVector(head + head2, tail + tail2)
    }
  }
}
