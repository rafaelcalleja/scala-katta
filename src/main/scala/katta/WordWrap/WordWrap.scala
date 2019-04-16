package katta.WordWrap

object WordWrap
{
  implicit class WordWrapUtils(text: String) {
    def wordWrap(columns: Int): String =  {
      val paragraph = Paragraph(Words(text), columns)
     // paragraph.mkString(Paragraph.newLine)

      /*val textLine = new TextLine(Words(text), columns)
      textLine.mkString("n")*/
      paragraph.iterator.toList.mkString("n")
    }
  }
}