package katta.Permutations

object Permutations {
  def apply(value: String): Array[String] = {
    val list = value.toList.map(x => x.toString)

    var ret = List[String]()

    val iterateOver = list.zipWithIndex.map{ case(x,i) => list(i) + list.filter(_ != list(i)).mkString}

    iterateOver.zipWithIndex.foreach(
      { case(x,y) => x.zipWithIndex.foreach{ case(a, b)  => ret = x.toList(b) + x.toList.filter(_ != x.toList(b)).mkString :: ret} }
    )

    ret.distinct.toArray
  }
}
