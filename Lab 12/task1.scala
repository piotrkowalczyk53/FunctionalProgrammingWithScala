import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Success, Failure, Random}
import scala.concurrent.duration._

object Main{
  def main(args: Array[String]): Unit = {
    val x = Random.alphanumeric
    val rstr = (x take 100).toVector
    val found = psearch(rstr, 'x')
    found onComplete{
      case Success(f) => println("found " + f )
      case Failure(f) => println("not found" + f)
    }
  }
  
  def subSearch(data: Vector[Char], ans:Char):Char = {
    if(data.contains(ans)) 
      ans
    else
      '.'
  }

  def psearch(data: Vector[Char], ans: Char) : Future[List[Char]] = {
    val divided = data.grouped(data.size/10).toList
    val answer = for(e <- divided) yield Future{subSearch(e, ans)}
    Future.sequence(answer)
  }
}
