package Week1

object session {
  def abs(x: Double) = if (x > 0) x else -x       //> abs: (x: Double)Double
  def sqrt(x: Double): Double = {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(x, guess)) guess
    else sqrtIter(improve(guess, x), x)
  def isGoodEnough(guess: Double, x: Double): Boolean =
  	abs(guess * guess - x) / x < 0.001
  def improve(guess: Double, x: Double): Double =
  	(guess + x / guess) / 2
  sqrtIter(1.0, x)
  }                                               //> sqrt: (x: Double)Double|
  sqrt(2.0)
  sqrt(4.0)
}