package essential.IntList

import org.scalatest.{FlatSpec, Matchers}

class IntListTest extends FlatSpec with Matchers {
  "length" should "returns the length of the list" in {
    val example = Pair(1, Pair(2, Pair(3, End)))

    example.length should be (3)
    example.tail.length should be (2)
    End.length should be (0)
  }

  "product" should "compute the product of the elements in an IntList" in {
    val example = Pair(1, Pair(2, Pair(3, End)))

    example.product should be (6)
    example.tail.product should be (6)
    End.product should be (1)
  }

  "double" should "return double the value of each element in an IntList" in {
    val example = Pair(1, Pair(2, Pair(3, End)))

    example.double should be (Pair(2, Pair(4, Pair(6, End))))
    example.tail.double should be (Pair(4, Pair(6, End)))
    End.double should be (End)
  }
}