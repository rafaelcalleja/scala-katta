package katta.WordWrap

object Word {
  def apply(word: String): Word = new Word(word)
}

final case class Word(word: String) {
  def length: Int = word.length
  def text: String = word
}