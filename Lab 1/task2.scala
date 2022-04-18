object Main {
  def main(args: Array[String]): Unit = {
  println(sumAll(1,2,3,4,5))
  println(sumAll(1,1))
  println(repN(10, (x: Int) => x*2, 2))
  }

  def sumAll(input: Int*): Int = {
    var output = 0;
    for(x <- input)
      output += x;
    output
  }

  def repN(repeat: Int, fun: Int => Int, value: Int) : Int = {
    if(repeat == 0)
      return value
    repN(repeat-1, fun, fun(value))
    }
}
