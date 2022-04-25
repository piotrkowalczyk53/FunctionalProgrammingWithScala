object Main {
  def main(args: Array[String]): Unit = {
    val l = List(1, "hello", 2.56, 0x45, "key")
    val s = l.map(stream).mkString(" ")
    println(s)
  }

  def stream (x: Any): String = 
  {
      x match {
        case y:Int => " Int(" + y + ")"
        case y:String => " String(" + y + ")"
        case y:Double => " Double(" + y + ")"
      }
  }
}
