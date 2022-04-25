object Main {
  def main(args: Array[String]): Unit = {
    val data = List(
      Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),
      Map("company" -> "ABB", "origin" -> "Sweden"),
      Map("name" -> "Katarzyna", "fname" -> "Nowak", "age" -> "45"),
      Map("company" -> "F4", "origin" -> "Poland"),
      List("Cos", "innego"),
      Map("company" -> "Salina Bochnia", "origin" -> "Poland"),
      Map("company" -> "AGH", "origin" -> "Poland"),
      Map("name" -> "Krzysztof", "fname" -> "Krol", "age" -> "14")
      )

    getCompanies(data).foreach(println)
  }
  
  def getCompanies(toFilter: List[Any]): List[Any] ={
    val result = for(record <- toFilter) yield filterRecords(record).getOrElse(None)
    result.filter(_ != None)
  }

  def filterRecords(record: Any): Option[Company] ={
    record match{
      case map: Map[String, String] if map.contains("company") => Some(new Company(map.get("company").get, map.get("origin").get))
      case _ => None
    }
  }
}

case class Company (name: String, origin: String)
