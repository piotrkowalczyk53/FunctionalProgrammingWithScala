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
  
  def repN(repeat: Int, fun: Int => Int, value: Int) : Int = {
    if (repeat == 0)
      return value
    repN(repeat-1, fun, fun(value))
  }
}
