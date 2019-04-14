package katta.WordWrap

object WordWrap
{
  implicit class WordWrapUtils(text: String) {
    def wordWrap(columns: Int): String =  {
      var mutableText = text
      var returnString: String = ""
      val newLineChar = "n"

      do {
        var nextIndex = mutableText.slice(0, columns).lastIndexOfSlice(" ")
        if (nextIndex < 0 || mutableText.length <= columns) nextIndex = columns
        returnString = returnString + mutableText.slice(0, nextIndex) + newLineChar
        mutableText = mutableText.replace(mutableText.slice(0, nextIndex), "").replaceAll("^\\s+", "")
      }
      while (mutableText != "")

      returnString.replaceAll("^"+newLineChar, "").replaceAll(newLineChar+"$", "")
    }
  }
}