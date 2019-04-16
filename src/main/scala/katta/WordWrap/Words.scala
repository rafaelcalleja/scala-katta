package katta.WordWrap

object Words {
  def apply(text: String): Words = new Words(text)
}

case class Words(text: String) extends Seq[Word] {
  override def length: Int = text.length

  override def iterator: Iterator[Word] = text.split(" ").map { x => Word(x)}.toIterator

  override def apply(idx: Int): Word = this(idx)
}

object Word {
  def apply(word: String): Word = new Word(word)
}

final case class Word(word: String) {
  def length: Int = word.length
  def text: String = word
}
