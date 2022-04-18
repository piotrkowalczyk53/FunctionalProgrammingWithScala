object counter {
  def main(args: Array[String]): Unit = {
    println(countCharacters(args.toList))
  }

def countCharacters(phrase: List[String]): Int = {
  @scala.annotation.tailrec
  def countLetters(word: String, counter: Int = 0) : Int = {
    if(word.isEmpty)
      return counter
    countLetters(word.tail, counter + 1)
  }
  
  @scala.annotation.tailrec
  def countRec(words: List[String], counter: Int = 0) : Int = {
    if(words.isEmpty)
      return counter
    countRec(words.tail, counter + countLetters(words.head))
  }
  countRec(phrase)
  }
}
