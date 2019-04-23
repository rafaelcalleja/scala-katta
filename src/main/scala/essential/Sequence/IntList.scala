package essential.Sequence

sealed trait IntList {
  def length: Int = fold[Int](0, (_, tail) => 1 + tail )

  def double: IntList = fold[IntList](End, (that, tail) => Pair(that * 2, tail) )

  def product: Int = fold[Int](1, (that, next) => that * next)

  def sum: Int = fold[Int](0, (that, next) => that + next)

  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
}

case object End extends IntList
case class Pair(head: Int, tail: IntList) extends IntList