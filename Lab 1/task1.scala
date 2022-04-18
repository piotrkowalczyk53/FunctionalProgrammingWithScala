object Main {
  def main(args: Array[String]): Unit = {
    println(generateWithoutSquares(if (args.length > 0) args(0).toInt else 50).mkString(" "))

    
    val x = Array.ofDim[Int](4,5)
    for (i <- 0 until 4; j <- 0 until 5) x(i)(j) = i+j
    print2DArray(x)

    val y = Array.ofDim[Int](4,5)
    for (i <- 0 until 4; j <- 0 until 5) y(i)(j) = 4
    print2DArray(y)


    print2DArray(merge2DArrays(x, y))
  }
  
  def generateWithoutSquares (N: Int = 50) : Array[Int] = {
    val generatedInts = for {x <- 1 to N if !Math.sqrt(x).isWhole} yield x
    generatedInts.toArray
  }

  def print2DArray(toPrint: Array[Array[Int]]) : Unit = {
    println()
    for (i <- 0 until toPrint.length)
    {
      print("|")
      for (j <- 0 until toPrint(i).length)
      {
        print(s" ${toPrint(i)(j)}")
      }
      print(" |\n")
    }
  }

  def merge2DArrays(arr1: Array[Array[Int]], arr2: Array[Array[Int]]) : Array[Array[Int]] = {
    val result = Array.ofDim[Int](arr1.length,arr1(0).length)
    for (i <- 0 until arr1.length; j <- 0 until arr2(i).length){
      result(i)(j) = if(arr1(i)(j) > arr2(i)(j)) arr1(i)(j) else arr2(i)(j)
    }
    result
  }
}
