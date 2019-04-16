package katta.WordWrap

case class Paragraph(value: TextLine) {
  def next: Option[Paragraph] =  {
    val textLine = value

    if ("" != textLine.excessText) {
      val nextTextLine = TextLine(Words(textLine.excessText), textLine.maxLength)
      Some(Paragraph(nextTextLine))
    } else {
      None
    }
  }
}

object Paragraph {
  def apply(words: Words, columns: Int): Paragraph = {
    val currentTextLine = TextLine(words, columns)
    Paragraph(currentTextLine)
  }

  implicit class Iterable(val node: Paragraph) extends AnyVal {
    def iterator: Iterator[TextLine] = Iterator
      .iterate(Option(node))(_.flatMap(_.next))
      .takeWhile(_.nonEmpty)
      .flatten
      .map(_.value)
  }
}