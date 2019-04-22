package essential

/**
  * Recursive Algebraic Data Types Pattern
  *
  * When defining recursive algebraic data types, there must be at least
  * two cases: one that is recursive, and one that is not. Cases that are not
  * recursive are known as base cases. In code, the general skeleton is:
  *
  * We have three way of implementing structural recursion:
  * 1. polymorphism;
  * 2. pattern matching in the base trait; and
  * 3. pattern matching in an external object (as in the Diner example above).
  *
  * With OO style we can easily add new data,
  * by extending a trait, but adding a new method requires us to change existing
  * code.
  *
  * With functional style we can easily add a new method but adding new
  * data requires us to modify existing code
**/

/**
  * pattern matching in the base trait
  */
sealed trait Tree {
  def sum: Int = this match {
    case Leaf(element) => element
    case Node(left, right) => left.sum + right.sum
  }

  def double: Tree = this match {
    case Leaf(element) => Leaf(element * 2)
    case Node(left, right) => Node(left.double, right.double)
  }
}
case class Node(left: Tree, right: Tree) extends Tree
case class Leaf(element: Int) extends Tree

/**
  * polymorphism
  */
sealed trait TreeP {
  def sum: Int

  def double: TreeP
}

final case class NodeP(left: TreeP, right: TreeP) extends TreeP {
  def sum: Int = left.sum + right.sum

  def double: TreeP = NodeP(left.double, right.double)
}

case class LeafP(element: Int) extends TreeP {
  override def sum: Int = element

  override def double: TreeP = LeafP(element * 2)
}