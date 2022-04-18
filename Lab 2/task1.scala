object Main {
  def main(args: Array[String]): Unit = {
    println(pi)
    println(pi(pi))
    println(pi(pi(pi)))
    printarg(arg = "hello")
    printarg()
    println(repN(5, (x: Int) => 2*x , 1 ))
  }

  def pi() : Double = {
    3.1415
  }
  
  def pi(arguments: Double) : Double = {
    arguments * pi()
  }
  
  def printarg(arg: String) : Unit ={
    println(arg)
  }
  
  def printarg() : Unit = {
    println("-")
  }
  
  def repN(times: Int, fun: Int => Int, first: Int) : Int = {
    if (times == 0)
      return first
    repN(times-1, fun, fun(first))
  }
}
