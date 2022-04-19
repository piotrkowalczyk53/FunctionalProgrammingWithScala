object Main 
{
  def main(args: Array[String]): Unit = {
    val myPizza = new ThinDough with TomatoSauce with Mozarella with Ham
    println(myPizza.name + myPizza.price)
    val yourPizza = new ThinDough with TomatoSauce with Mozarella with Mushrooms
    println(yourPizza.name + yourPizza.price)
  }

  abstract class PizzaTopping()
  {
    def name : String
    def price : Int
  }

  class ThinDough extends PizzaTopping
  {
    override def name : String = " on thin dough "
    override def price : Int = 10
  }

  trait TomatoSauce extends PizzaTopping
  {
    override abstract def name : String = " Tomato Sauce" + super.name
    override abstract def price : Int = super.price + 1
  }

  trait Mozarella extends PizzaTopping
  {
    override abstract def name : String = " Mozarella" + super.name
    override abstract def price : Int = super.price + 3
  }

  trait Ham extends PizzaTopping
  {
    override abstract def name : String = " Ham" + super.name
    override abstract def price : Int = super.price + 5
  }

  trait Mushrooms extends PizzaTopping
  {
    override abstract def name :String = " Mushrooms" + super.name
    override abstract def price : Int = super.price + 2
  }
}
