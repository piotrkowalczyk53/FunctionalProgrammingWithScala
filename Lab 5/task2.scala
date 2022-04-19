object Main{
  def main(args: Array[String]): Unit = {
    val p = new Point
    p.setColor(56, 0, 120)
    println(p)

    val pc = new Point with Color
    pc.setColor(56, 0, 120)
    pc.decreaseBlueBy(120)
    pc.increaseRedBy(500)
    println(pc)
  }
}

trait Color{
  def setColor(r: Int, g: Int, b: Int): Unit
  def getColor: (Int, Int, Int)

  def changeColor(index: Int, change: Float): Unit = {
    val rgb = getColor
    index match{
      case 1 => setColor(if((rgb._1 * change).toInt > 255) 255 else (rgb._1 * change).toInt, rgb._2, rgb._3)
      case 2 => setColor(rgb._1, if((rgb._2 * change).toInt > 255) 255 else (rgb._2 * change).toInt, rgb._3)
      case 3 => setColor(rgb._1, rgb._2, if((rgb._3 * change).toInt > 255) 255 else (rgb._3 * change).toInt)
    }
  }

  def increaseRedBy(percentage: Float) = changeColor(1, 1 + percentage/100)
  def decreaseRedBy(percentage: Float) = changeColor(1, if(1 - percentage/100 < 0) 0f else 1 - percentage/100)
  def increaseGreenBy(percentage: Float) = changeColor(2, 1 + percentage/100)
  def decreaseGreenBy(percentage: Float) = changeColor(2, if(1 - percentage/100 < 0) 0f else 1 - percentage/100)
  def increaseBlueBy(percentage: Float) = changeColor(3, 1 + percentage/100)
  def decreaseBlueBy(percentage: Float) = changeColor(3, if(1 - percentage/100 < 0) 0f else 1 -percentage/100)
}

class Point{
  private var rgb = (0, 0, 0)
  def setColor(r: Int, g: Int, b: Int): Unit = rgb = (r, g, b)
  def getColor: (Int, Int, Int) = (rgb._1, rgb._2, rgb._3)
  override def toString: String = getColor.toString
}
