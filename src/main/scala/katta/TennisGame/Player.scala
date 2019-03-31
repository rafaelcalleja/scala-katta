package katta.TennisGame

case class Player (var name: String)

/*class Player {
  var name: String = _
}

object Player {
  def apply(name: String): Player = {
    var p = new Player
    p.name = name
    p
  }

// want accessor and mutator methods for the name and age fields
case class Person (var name: String, var age: Int)

// define two auxiliary constructors
object Person {
    def apply() = new Person("<no name>", 0)
    def apply(name: String) = new Person(name, 0)
}
}*/