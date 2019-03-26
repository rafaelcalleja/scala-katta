package katta.BerlinClock

import katta.UnitSpec

class BerlinClockSpec extends UnitSpec {
  "Red lamp" should "can switch state" in {
    new RedLight().Off().toString() should be ("O")
    new RedLight().On().toString() should be ("R")
    new RedLight().On().Toggle().toString() should be ("O")
  }

  "On Circuit" should "switch on always" in {
    new OnCircuit(new RedLight()).on(0) should be (true)
    new OnCircuit(new RedLight()).on(10) should be (true)
    new OnCircuit(new YellowLight).on(5) should be (true)
  }

  "On Circuit" should "print light" in {
    new OnCircuit(new RedLight()).supply(0).toString() should be ("R")
    new OnCircuit(new YellowLight).supply(0).toString() should be ("Y")
  }

  "Led Panel" should "had lights" in {
    new Panel(
      1,
      Array(
        new OnCircuit(new RedLight()),
        new OnCircuit(new YellowLight)
      )
    )
    .toString() should be ("RY")
  }

  "Blink Panel" should "blink on/off every two seconds" in {
    new BlinkPanel(0).toString() should be ("Y")
    new BlinkPanel(1).toString() should be ("O")
    new BlinkPanel(11).toString() should be ("O")
  }

  "Top hours panel" should "have 4 lamps" in {
    new TopHourPanel(7).Length should be (4)
  }

  "Top Hour panel" should "light a red lamp for every 5 pulses" in {
    new TopHourPanel(4).toString should be ("OOOO")
    new TopHourPanel(10).toString should be ("RROO")
    new TopHourPanel(23).toString should be ("RRRR")
    new TopHourPanel(24).toString should be ("RRRR")
  }

  "Bottom hours panel" should "have 4 lamps" in {
    new BottomHourPanel(5).Length should be (4)
  }

  "Bottom Hour panel" should "light a red lamp for every hour left from top hours panel" in {
    new BottomHourPanel(4).toString should be ("OOOO")
    new BottomHourPanel(13).toString should be ("RRRO")
    new BottomHourPanel(23).toString should be ("RRRO")
    new BottomHourPanel(24).toString should be ("RRRR")
  }

  "Top minutes" should "have 11 lamps" in {
    new TopMinutesPanel(34).Length should be (11)
  }

  "Top Minutes Panel" should "have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter" in {
    val minutes32 =  new TopMinutesPanel(32).toString
    minutes32(2) should be ('R')
    minutes32(5) should be ('R')
    minutes32(8) should be ('O')
  }

  "Top Minutes Panel" should "light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter panel" in {
    new TopMinutesPanel(0).toString should be ("OOOOOOOOOOO")
    new TopMinutesPanel(17).toString should be ("YYROOOOOOOO")
    new TopMinutesPanel(59).toString should be ("YYRYYRYYRYY")
  }

  "Bottom minutes Panel" should "have 4 lamps" in {
    new BottomMinutesPanel(0).Length should be (4)
  }

  "Bottom minutes Panel" should "light a yellow lamp for every minute left from top minutes panel" in {
    new BottomMinutesPanel(0).toString should be ("OOOO")
    new BottomMinutesPanel(17).toString should be ("YYOO")
    new BottomMinutesPanel(59).toString should be ("YYYY")
  }

  "Berlin Clock" should "result in array with 5 elements" in {
    BerlinClockPanel.convertToBerlinTime("13:17:01").length should be (5)
  }

  "Berlin Clock Panel" should "result in correct seconds, hours and minutes using panel" in {
    val berlinTime = BerlinClockPanel.convertToBerlinTime("16:37:16")
    val expected = Array("Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO")
    berlinTime should equal (expected)
  }
}
