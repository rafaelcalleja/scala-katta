package katta.WordWrap
object TextLine
{
  def apply(words: Words, maxLength: Int): TextLine = new TextLine(words, maxLength)
}

final case class TextLine(words: Words, maxLength: Int) {
  val lineText: String = breakLineText
  val excessText: String = words.text.replace(lineText, "").replaceAll("^\\s+", "")

  override def toString: String = lineText

  def breakLineText: String = {
    words.foldLeft(""){ (currentTextLine: String, currentWord: Word) => if((currentTextLine.length + currentWord.length <= maxLength) || words.length <= maxLength ) (currentTextLine + " " + currentWord.text).replaceAll("^\\s+", "") else return currentTextLine }
  }
}
