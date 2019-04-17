package katta.WordWrap

import scala.language.implicitConversions

object Words {
  def apply(): Words = new Words("")
  def apply(text: String): Words = new Words(text)

  implicit def String2Words(text: String): Words = Words(text)
}

case class Words(text: String, wordSeparator: String = " ") extends Seq[Word] {
  def +=(elem: Word): Words = Words((this.text + wordSeparator + elem.text.toString).replaceAll("^\\s+", ""))

  override def length: Int = text.length

  override def iterator: Iterator[Word] = text.split(wordSeparator).map { x => Word(x)}.toIterator

  override def apply(idx: Int): Word = this(idx)

  override def toString: String  = text
}
