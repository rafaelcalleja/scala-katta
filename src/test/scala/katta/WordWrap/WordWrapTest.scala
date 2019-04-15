package katta.WordWrap

import org.scalatest.{Matchers, FlatSpec}
import katta.WordWrap.WordWrap._

class WordWrapTest extends FlatSpec with Matchers {

  "WordWrap" should "return empty string is no text is specified" in {
    "".wordWrap(10) should be ("")
  }

  it should "work with a single word" in {
    "kata".wordWrap(4) should be ("kata")
  }

  it should "return wrapped text with small sample" in {
    val input = "This kata"
    val expected = "Thisnkata"
    input.wordWrap(4) should be (expected)
  }

  it should "return wrapped text" in {
    val input = "This kata should be easy unless there are hidden, or not so hidden, obstacles. Let's start!"
    val expected = "This katanshould beneasy unlessnthere arenhidden, ornnot sonhidden,nobstacles.nLet's start!"
    input.wordWrap(12) should be (expected)
  }

  it should "return the same text if max length is the same as the length of the text" in {
    val input = "Lorem ipsum dolor sit amet."
    val expected = "Lorem ipsum dolor sit amet."
    input.wordWrap(input.length) should be (expected)
  }

}