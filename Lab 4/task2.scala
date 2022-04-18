object Main{
  def main(args: Array[String]): Unit = {
    val bk = new Bookkeeping()
    bk -= Expense(20, "lunch")
    bk -= Expense(200, "jacket")
    bk += Income(1000, "subsistence", "10 October")
    
    println(s"Current Balance = ${bk.getBalance}")
    println("------------------------------------")        
    println("Incomes:")
    bk.printIncomes
    println("------------------------------------")
    println("Expenses:")
    bk.printExpenses
    println("------------------------------------")
  }
}

class Bookkeeping{
  private var balance = 0
  private var listOfExpenses = List[Expense]()
  private var listOfIncomes = List[Income]()

  def -=(operation: Expense) = {
    listOfExpenses = listOfExpenses :+ operation
    balance -= operation.amount
  }
  def +=(operation: Income) = {
    listOfIncomes = listOfIncomes :+ operation
    balance += operation.amount
  }

  def getBalance: Int = balance
  def printIncomes: Unit = for(x <- listOfIncomes) println(x.toString)
  def printExpenses: Unit = for(x <- listOfExpenses) println(x.toString)
}

class Expense(val amount: Int, val description: String){
  override def toString = s"\t-$amount  Title: $description"
}
object Expense{
  def apply(amount: Int, description: String) = new Expense(amount, description)
}

class Income(val amount: Int, val description: String, val date: String){
  override def toString = s"\t$amount  Title: $description  date: $date"
}
object Income{
  def apply(amount: Int, description: String, date: String) = new Income(amount, description, date)
}
