package katta.BerlinClock

abstract class Light {
  var Color: String
  var State: Boolean = true

  def On(): Light = {
    State = true
    this
  }

  def Off(): Light = {
    State = false
    this
  }

  def Toggle(): Light = {
    if (State)
      Off()
    else
      On()
  }

  override def toString: String = {
    if (State)
      Color
    else
      "O"
  }
}

class RedLight extends Light {
  var Color: String = "R"
}

class YellowLight extends Light {
  var Color: String = "Y"
}

class Panel(moment: Int, CircuitsLights: Array[CircuitsLight])
{
  def Length: Int = CircuitsLights.length

  override def toString: String = {
    CircuitsLights.map(_.supply(moment)).map(_.toString).mkString("")
  }
}

abstract class CircuitsLight(light: Light)
{
  def on(moment: Int): Boolean

  def supply(moment: Int): CircuitsLight = {
    light.Off()

    if (on(moment)) {
      light.On()
    }

    this
  }

  override def toString: String = {
    light.toString()
  }
}


class OnCircuit(light: Light) extends CircuitsLight (light) {
  def on(moment: Int): Boolean = {
    true
  }
}

class BlinkCircuit(light: Light) extends CircuitsLight (light) {
  def on(moment: Int): Boolean = {
    moment % 2 == 0
  }
}

class PulsesCircuit(pulse: Int, light: Light) extends CircuitsLight (light) {
  def on(moment: Int): Boolean = {
    moment >= pulse
  }
}

class BlinkPanel(moment: Int) extends {

} with Panel (moment, Array(
  new BlinkCircuit(new YellowLight)
))

class TopHourPanel(moment: Int) extends {
} with Panel (moment, Array(
    new PulsesCircuit(5, new RedLight()),
    new PulsesCircuit(10, new RedLight),
    new PulsesCircuit(15, new RedLight),
    new PulsesCircuit(20, new RedLight)
))

abstract class Lamp extends Light {
  val size: Int
}

object BerlinClock {
  def seconds(second: Int) : String = {
    if (second % 2 == 0)
      "Y"
    else
      "O"
  }

  def topHours(hour: Int): String = {
    val div: Int = math.floor(hour / 5).toInt

    if (div == 4)
      "RRRR"
    else if (div == 3)
      "RRRO"
    else if (div == 2)
      "RROO"
    else if (div == 1)
      "ROOO"
    else
      "OOOO"
  }

  def bottomHours(hour: Int): String = {
    val div: Int = hour - (math.floor(hour / 5).toInt * 5)

    if (div == 4)
      "RRRR"
    else if (div == 3)
      "RRRO"
    else if (div == 2)
      "RROO"
    else if (div == 1)
      "ROOO"
    else
      "OOOO"
  }

  def topMinutes(minutes: Int): String = {
    val div: Int = math.floor(minutes / 5).toInt

    if (div == 11)
      "YYRYYRYYRYY"
    else if (div == 10)
      "YYRYYRYYRYO"
    else if (div == 9)
      "YYRYYRYYROO"
    else if (div == 8)
      "YYRYYRYYOOO"
    else if (div == 7)
      "YYRYYRYOOOO"
    else if (div == 6)
      "YYRYYROOOOO"
    else if (div == 5)
      "YYRYYOOOOOO"
    else if (div == 4)
      "YYRYOOOOOOO"
    else if (div == 3)
      "YYROOOOOOOO"
    else if (div == 2)
      "YYOOOOOOOOO"
    else if (div == 1)
      "YOOOOOOOOOO"
    else
      "OOOOOOOOOOO"
  }

  def bottomMinutes(minutes: Int): String = {
    val div: Int = minutes - (math.floor(minutes / 5).toInt * 5)

    if (div == 4)
      "YYYY"
    else if (div == 3)
      "YYYO"
    else if (div == 2)
      "YYOO"
    else if (div == 1)
      "YOOO"
    else
      "OOOO"
  }

  def convertToBerlinTime(dateTime: String): Array[String] = {
    val dateTimeArray: Array[String] = dateTime.split(":")

    Array(
      seconds(dateTimeArray(2).toInt),
      topHours(dateTimeArray(0).toInt),
      bottomHours(dateTimeArray(0).toInt),
      topMinutes(dateTimeArray(1).toInt),
      bottomMinutes(dateTimeArray(1).toInt)
    )
  }


}