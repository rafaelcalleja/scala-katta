package katta.WordWrap
object TextLine
{
  def apply(words: Words, maxLength: Int): TextLine = new TextLine(words, maxLength)
  def apply(text: String, maxLength: Int): TextLine = new TextLine(Words(text), maxLength)
}

final case class TextLine(words: Words, maxLength: Int) {
  val lineText: Words = breakLineText
  val excessText: String = words.text.replace(lineText.toString, "").replaceAll("^\\s+", "")

  override def toString: String = lineText.toString

  private def breakLineText: Words = {
    words.foldLeft(Words()){ (wordsOfLine: Words, wordToAdd: Word) => if((wordsOfLine.length + wordToAdd.length <= maxLength) || words.length <= maxLength ) wordsOfLine += wordToAdd else return wordsOfLine }
  }
}
