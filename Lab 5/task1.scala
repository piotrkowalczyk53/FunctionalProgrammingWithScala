object Main {
  def main(args: Array[String]): Unit = {
    val a = Angle(4.5)
    println(a)
    
    val b = Angle.Zero
    println(b)
    
    val c = Angle.Pi
    println(c)
    
    val d = Angle.halfPi
    println(d)
    
    val e = Angle.DR(a, b)(c, d)
    println(e)
  }
}

class Angle (val angle: Double){
  def +(otherAngle: Angle): Angle = Angle(otherAngle.angle + angle)
  def -(otherAngle: Angle): Angle = Angle(otherAngle.angle - angle)
  def *(otherAngle: Double): Angle = Angle(angle*otherAngle)
  def /(otherAngle: Double): Angle = Angle(angle/otherAngle)
  
  override def toString(): String = s"angle [-pi, pi) $angle"
}

object Angle{
  @scala.annotation.tailrec
  def toRange (angle: Double): Double ={
    if (angle > math.Pi)
      toRange(angle - 2*math.Pi)
    else if (angle < -math.Pi)
      toRange(angle + 2*math.Pi)
    else
      return angle
  }
  def apply(angle: Double) = new Angle(toRange(angle))
  val halfPi = Angle(math.Pi/2)
  val Pi = Angle(math.Pi)
  val Zero = Angle(0)
  def DR (angle1: Angle, angle2: Angle)(angle3: Angle, angle4: Angle): Angle = {
    Angle(math.sqrt((angle1 - angle2).angle*(angle1 - angle2).angle + ((angle3 - angle4).angle*(angle3 - angle4).angle)))
  }
}
