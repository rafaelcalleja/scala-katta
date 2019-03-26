package katta.PrimeFactor

object PrimeFactors {
  def result(number: Int, list: List[Int] = List[Int]()): List[Int] = {
    for (i <- 2 to number if number % i == 0) {
      return result(number / i, list :+ i)
    }
    list
  }

  def resultado(number: Int): List[Int] = {
    var nextNumber = number
    var returnList = List[Int]()
    if (number == 1)
        List()
    else {
      do {
        var nextList = reduce(nextNumber)
        nextNumber = nextList.map { case (x,y) => y }.head
        returnList = returnList :+ nextList.map { case (x,y) => x }.head
      } while (
        reduceTimes(nextNumber) >= 1
      )

      returnList
    }
  }

  def reduce(number: Int): List[(Int, Int)] = {
    (for (i <- (2 to number).toList) yield if(number % i == 0) i -> number / i else i -> 0).filter  { case (x,y) => y > 0}.take(1)
  }

  def reduceTimes(number: Int): Int = {
    (for (i <- (2 to number).toList) yield if(number % i == 0) i -> number / i else i -> 0).count  { case (x,y) => y > 0}
  }
}
