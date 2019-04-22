package katta.Exercise

import scala.language.implicitConversions

case class Cat(name: String, color: String, food: String) {

}

object Cat {
  def apply(name: String, color: String, food: String): Cat = new Cat(name, color, food)
}

/**
val cat1 = Cat("Oswald", "Black", "Milk")
val cat2 = Cat("Henderson", "Ginger", "Chips")
val cat3 = Cat("Quentin", "Tabby and White", "Curry")
*/

object Calc {
  def square(wide: Double) : Double = wide * wide

  def cube(wide: Double): Double = square(wide) * wide
}

object Cal2c {
  def square(wide: Double) : Double = wide * wide
  def cube(wide: Double): Double = square(wide) * wide

  def square(wide: Int) : Double = wide * wide
  def cube(wide: Int): Double = square(wide) * wide
}

case class Counter(value: Int = 0) {
  def incr(newValue: Int = 1): Counter = copy(value + newValue)
  def decr(newValue: Int = 1): Counter = copy(value - newValue)

  def incr: Counter = incr()
  def decr: Counter = decr()
}

object Counter {
  implicit def CounterToInt(counter: Counter): Int = counter.value
  implicit def CounterToString(counter: Counter): String = counter.value.toString
}