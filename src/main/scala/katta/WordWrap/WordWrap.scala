package katta.WordWrap

object WordWrap
{
  implicit class WordWrapUtils(text: String) {
    def wordWrap(columns: Int): String =  {
      val paragraph = Paragraph(text, columns)
      paragraph.iterator.mkString("n")
    }
  }
}