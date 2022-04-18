object Main {
  def main(args: Array[String]): Unit = {
  println(sumAll(1,2,3,4,5))
  println(sumAll(1,1))
  println(repN(10, (x: Int) => x*2, 2))
  }

  def sumAll(input: Int*): Int = {
    var output = 0;
    for(e <- input) output += e;
    output
  }

  def repN(count: Int, fun: Int => Int, value: Int) : Int = {
    if(count == 0)
      return value
    repN(count-1, fun, fun(value))
    }
}
