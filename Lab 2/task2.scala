object Main {
  def main(args: Array[String]): Unit = {
    val sum1 = sumfrac(1e-3)
    val sum2 = sumfrac(1e-9)
    val sum3 = sumfrac(1e-16)

    println(sum1)
    println(sum2)
    println(sum3)
  }

  def sumfrac (precision: Double) : Double = {
    @scala.annotation.tailrec
    def recSumfrac(value: Double, times: Int) : Double = {
      if (1/Math.pow(2, times) < precision)
        return value
      else
        recSumfrac(value + 1/Math.pow(2, times), times+1)
    }
      recSumfrac(0, 0)
    }
  }
