object Main {
  def main(args: Array[String]): Unit = {
    val a = List(-8,5,6,1,4,4,2,5,-1,9,9)
    val team = List(Person(0, 25, "Jerry"), Person(1, 34, "Jane"), Person(2, 25, "Jim"), Person(3, 19, "Judith"))
    
    println(repeated(a))
    println(unique(a))
    println(consecutive(a))
    println(select_from(team, (x: Person) => x.id, 1, 3))
    println(select_from(team, (x: Person) => x.age, 25))
    println(condMerge(List(2, -9, 1, 8), Vector(3, -2, 45, 2), {case x: (Int, Int) if Math.max(x._1, x._2) > 0 => Math.max(x._1, x._2) case _ => -1}))

  }

  def repeated (arg: List[Int]): Any = {
    arg.groupBy(identity).collect {case (x, List(_,_,_*)) => x}
  }

  def unique (arg: List[Int]): Any = {
    arg.toSet
  }

  def consecutive (arg: List[Int]): Any = {
    arg.sliding(2).collect {case Seq(a, b) if a == b => b}.toList
  }

  case class Person(val id: Int, val age: Int, name: String);

  def select_from(arg: List[Person], f: Person => Int, a: Int*) : Any = {
    arg.filter(z => a.contains(f(z)))
  }

  def condMerge(x: Iterable[Int], y: Iterable[Int], z: ((Int, Int)) => Int): List[Int] = {
    x.zip(y).map(z).toList.filter(_ != -1)
  }
}
