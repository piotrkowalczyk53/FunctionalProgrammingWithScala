object Main {
  def main(args: Array[String]): Unit = {
    for ( i <- 1 to 10 ) {
      val z = randomly(0.25)
        {println("calling this"); 1}
        {println("calling that"); 2}

    println(z);
        }
    }

  def randomly(chance: Double)(output1: => Int)(output2: => Int): Int = {
    val random = new scala.util.Random
    if(random.nextDouble < chance)
      output1
    else
      output2
    }
}
