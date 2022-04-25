object Main {
  def main(args: Array[String]): Unit = {
    val people = List(
    ("John", "Doe", 23, "male"),
    ("Joan", "Doe", 23, "female"),
    ("Steve", "Jenkins", 22, "male"),
    ("Eva", "Robinson", 25, "female"),
    ("John", "Who", 22, "male"),
    ("Janet", "Reed", 21, "female"),
    ("Rob", "Jenkins", 22, "male"),
    ("Ella", "Dawson", 27, "female"))

    val listOfNames = people.collect(_._1)
    println(listOfNames)
    print("\n")

    val setOfNames = people.collect(_._1).toSet
    println(setOfNames)
    print("\n")

    val setOfAge = people.collect(_._3).toSet
    println(setOfAge)
    print("\n")

    val (aboveOr23, below23) = people.partition(_._3 >= 23)
    println(aboveOr23)
    println(below23)
    print("\n")

    val groupedByAge = people.groupBy(_._3)
    println(groupedByAge)
    print("\n")

    val sortedByAge = people.sortBy(_._3)
    println(sortedByAge)
    print("\n")

    val joeOrRob = people.exists(_._1 == "Joe") || people.exists(_._1 == "Rob")
    println(joeOrRob)
    print("\n")

    val(males, females) = people.partition(_._4 == "male")
    println(males.length == females.length)
  }
}
