package katta.WordWrap

case class Paragraph[TextLine](value: TextLine) {
  def next: Option[Paragraph[TextLine]] =  {
    val textLine = value.asInstanceOf[katta.WordWrap.TextLine]

    if ("" != textLine.excessText) {
      val nextTextLine = TextLine(Words(textLine.excessText), textLine.maxLength)
      Some(new Paragraph[TextLine](nextTextLine.asInstanceOf[TextLine]))
    } else {
      None
    }
  }
}

object Paragraph {
  def apply(words: Words, columns: Int): Paragraph[TextLine] = {
    val currentTextLine = TextLine(words, columns)
    Paragraph[TextLine](currentTextLine)
  }

  implicit class Iterable[TextLine](val node: Paragraph[TextLine]) extends AnyVal {
    def iterator: Iterator[TextLine] = Iterator
      .iterate(Option(node))(_.flatMap(_.next))
      .takeWhile(_.nonEmpty)
      .flatten
      .map(_.value)
  }
}