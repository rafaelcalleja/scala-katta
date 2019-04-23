package essential.LinkedList

import org.scalatest.{FlatSpec, Matchers}

class LinkedListTest extends FlatSpec with Matchers {
  "length" should "returns the length of the list" in {
    val example = LinkedPair(1, LinkedPair(2, LinkedPair(3, LinkedEnd())))

    example.length should be (3)
    example.tail.length should be (2)
    LinkedEnd().length should be (0)
  }
  "contains" should "compare all values for equality" in {
    val example = LinkedPair(1, LinkedPair(2, LinkedPair(3, LinkedEnd())))

    example.contains(3) should be (true)
    example.contains(4) should be (false)
    LinkedEnd().contains(0) should be (false)
  }

  "apply" should "returns the nth item in the list" in {
    val pair3 = LinkedPair(3, LinkedEnd())
    val pair2 = LinkedPair(2, pair3)
    val pair1 = LinkedPair(1, pair2)

    pair1(0) should be (Success(pair1))
    pair1(1) should be (Success(pair2))
    pair1(2) should be (Success(pair3))
    pair1(3) should be (Failure("Index out of bounds"))
  }
}