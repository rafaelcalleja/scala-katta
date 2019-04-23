package essential.LinkedList

import scala.annotation.tailrec

@tailrec
sealed trait LinkedList[A] {
  def length: Int = this match {
    case LinkedEnd() => 0
    case LinkedPair(_, tail) => 1 + tail.length
  }

  def contains(elemnent: A): Boolean = this match {
    case LinkedPair(elem, next) =>
      if (elemnent == elem)
        true
      else
        next.contains(elemnent)
    case LinkedEnd() => false
  }

  def apply(index: Int): Result[LinkedList[A]] = this match {
    case LinkedPair(elem, next) =>
      if (index == 0)
        Success(this)
      else
        next.apply(index - 1)
    case LinkedEnd() => Failure("Index out of bounds")
  }
}

case class LinkedEnd[A]() extends LinkedList[A]
final case class LinkedPair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

sealed trait Result[LinkedList]
case class Success[LinkedList](result: LinkedList) extends Result[LinkedList]
case class Failure[LinkedList](reason: String) extends Result[LinkedList]
