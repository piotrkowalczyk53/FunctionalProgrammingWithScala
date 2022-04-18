object Main {
  
  def main(args: Array[String]): Unit = {
  println(filterList(List("Hello", "there", "people"), _.contains('l')).mkString(" "))
  println(reverseList(List("Hello", "there", "people")).mkString(" "))
  println(List("Hello", "there", "people").reverse.mkString(" ")) //was asked not to use .reverse by proffesor
}

  def filterList(listToSort:List[String], filter: (String) => Boolean): List[String] = {
  
    @scala.annotation.tailrec
    def recFilter(workList: List[String], filteredList: List[String]): List[String] = {
      if(workList.isEmpty)
        filteredList
      else{
        if(filter(workList.head))
          recFilter(workList.tail, filteredList ++ List(workList.head))
        else
          recFilter(workList.tail, filteredList)
      }
    }

    return recFilter(listToSort, List())
  }
  

  def reverseList(listToReverse:List[String]): List[String] = {
  
    @scala.annotation.tailrec
    def recReverse(workList: List[String], reversedList: List[String]): List[String] = {
      if(workList.isEmpty)
        reversedList
      else
        recReverse(workList.tail, List(workList.head) ++ reversedList)
    }

    return recReverse(listToReverse, List())
  }
}
