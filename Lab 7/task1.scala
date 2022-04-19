object Main {
  def main(args: Array[String]): Unit = {
    val c: Plants = new Carrot
    val r = new Rabbit
    val w = new Wolf
    val a: Animal = r
    val f: Food = r
    r.eat(c)
    w.eat(r)
    //r.eat(r) //should not compile
    //w.eat(c) //should not compile
  }
}

trait Food
{
  val name = "Food"
  override def toString: String = name
}

abstract class Animal 
{
  val name = "Animal"
  type AcceptedType <: Food
  def eat (meal: AcceptedType): Unit
  override def toString: String = name
}

abstract class Plants extends Food
{
  override val name = "Plants"
}

trait Meat extends Food
{
  override val name = "Meat"
}

class Carrot extends Plants 
{
  override val name = "Carrot"
}

class Rabbit extends Animal with Meat{
  override val name = "Rabbit"
  override type AcceptedType = Plants
  override def eat(meal: AcceptedType): Unit = {println(s"$name crunches the $meal")}
}

class Wolf extends Animal
{
  override val name = "Wolf"
  override type AcceptedType = Meat
  override def eat(meal: AcceptedType): Unit = {println(s"$name tears apart the $meal")}
}
