object Main {
  def main(args: Array[String]): Unit = {
  val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)
  println(a(0))
  println(a(1))
  println(a)
  val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new B(77)) // covariantnes
  println(b)
  //val c: TwistedMonoPair[A] = new TwistedMonoPair[B](new B(9), new A) // should not compile because of second argument of c’tor
  val d1 = b.replace(0)(new A) // conversion to TwistedMonoPair[A] and replacement of the first el. in the pair
  println(d1)
  //val tA : TwistedMonoPair[A] = d1 //val tB : TwistedMonoPair[B] = d1// can not compile
  val d2 = b.replace(1)(new A) // as above, but replaced is the second el
  println(d2)
  }
}

class A{
  override def toString: String = "A"
}

class B(val x: Int) extends A{
  override def toString: String = "B:"+x.toString
}

class C(x: Int) extends B(x){
  override def toString: String = "C:"+x.toString
}

class TwistedMonoPair[+T](val arg1: T, val arg2: T){
  def replace[U>:T](index: Int)(toInsert: U): TwistedMonoPair[U] = {
    if(index == 0)
      TwistedMonoPair[U](toInsert, arg2)
    else
      TwistedMonoPair[U](arg1, toInsert)
  }
  
  override def toString: String = {
    arg1.toString + " " + arg2.toString
  }

  def apply(index: Int): T ={
    if(index == 0)
      arg1
    else
      arg2
  }
}
object TwistedMonoPair{
  def apply[T](arg1: T, arg2: T) = new TwistedMonoPair[T](arg1, arg2)
}
