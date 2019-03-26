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

class FractalCircuit(fractal: Int, pulse: Int, light: Light) extends CircuitsLight (light) {
  def on(moment: Int): Boolean = {
    var difference = math.floor(moment / fractal).toInt * fractal
    moment - difference >= pulse && difference > fractal
  }
}

class BlinkPanel(moment: Int) extends {

} with Panel (moment, Array(
  new BlinkCircuit(new YellowLight)
))

class TopHourPanel(moment: Int) extends {
} with Panel (moment, Array(
    new PulsesCircuit(5, new RedLight),
    new PulsesCircuit(10, new RedLight),
    new PulsesCircuit(15, new RedLight),
    new PulsesCircuit(20, new RedLight)
))

class BottomHourPanel(moment: Int) extends {
} with Panel (moment, Array(
  new FractalCircuit(5, 1, new RedLight),
  new FractalCircuit(5, 2, new RedLight),
  new FractalCircuit(5, 3, new RedLight),
  new FractalCircuit(5, 4, new RedLight)
))

class TopMinutesPanel(moment: Int) extends {
} with Panel (moment, Array(
  new PulsesCircuit(5, new YellowLight),
  new PulsesCircuit(10, new YellowLight),
  new PulsesCircuit(15, new RedLight),
  new PulsesCircuit(20, new YellowLight),
  new PulsesCircuit(25, new YellowLight),
  new PulsesCircuit(30, new RedLight),
  new PulsesCircuit(35, new YellowLight),
  new PulsesCircuit(40, new YellowLight),
  new PulsesCircuit(45, new RedLight),
  new PulsesCircuit(50, new YellowLight),
  new PulsesCircuit(55, new YellowLight),
))

class BottomMinutesPanel(moment: Int) extends {
} with Panel (moment, Array(
  new FractalCircuit(5, 1, new YellowLight),
  new FractalCircuit(5, 2, new YellowLight),
  new FractalCircuit(5, 3, new YellowLight),
  new FractalCircuit(5, 4, new YellowLight)
))


object BerlinClockPanel {
  def convertToBerlinTime(dateTime: String): Array[String] = {
    val dateTimeArray: Array[Int] = dateTime.split(":").map(_.toInt)

    Array(
      new BlinkPanel(dateTimeArray(2)).toString,
      new TopHourPanel(dateTimeArray(0)).toString,
      new BottomHourPanel(dateTimeArray(0)).toString,
      new TopMinutesPanel(dateTimeArray(1)).toString,
      new BottomMinutesPanel(dateTimeArray(1)).toString
    )
  }
}
