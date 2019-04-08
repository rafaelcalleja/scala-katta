package katta.Permutations

object Permutations {
  def apply(value: String): Array[String] = {
    permutate(value).distinct.toArray
  }

  def permutate(value: String, output: List[String] = List[String]()): List[String] = {
    val input = value.toList.map(x => x.toString)
    var returnOutput = output

    if (returnOutput.contains(value)) {
      return returnOutput
    }

    returnOutput = returnOutput :+ value

    input.zipWithIndex.foreach{ case(x,i) =>
        var newValue = input(i) + input.filter(_ != input(i)).mkString
        if (!returnOutput.contains(newValue)) {
           returnOutput = permutate(newValue, returnOutput)
        }
    }

    returnOutput.distinct
  }
}
