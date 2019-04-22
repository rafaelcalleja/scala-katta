package essential

import org.scalatest.{FlatSpec, Matchers}

class TreeTest extends FlatSpec with Matchers {
  "Tree polymorphism" should "sum and double" in {
    val trees = NodeP(LeafP(1), LeafP(2))

    trees.sum should be (3)
    trees.double should be (NodeP(LeafP(2), LeafP(4)))
    NodeP(NodeP(LeafP(2), LeafP(4)), NodeP(LeafP(2), LeafP(4))).double should be (NodeP(NodeP(LeafP(4), LeafP(8)), NodeP(LeafP(4), LeafP(8))))
  }

  "Tree pattern matching" should "sum and double" in {
    val trees = Node(Leaf(1), Leaf(2))

    trees.sum should be (3)
    trees.double should be (Node(Leaf(2), Leaf(4)))

    Node(Node(Leaf(2), Leaf(4)), Node(Leaf(2), Leaf(4))).double should be (Node(Node(Leaf(4), Leaf(8)), Node(Leaf(4), Leaf(8))))
  }
}