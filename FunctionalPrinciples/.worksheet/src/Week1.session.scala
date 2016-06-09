package Week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  def abs(x: Double) = if (x > 0) x else -x;System.out.println("""abs: (x: Double)Double""");$skip(357); 
  def sqrt(x: Double): Double = {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(x, guess)) guess
    else sqrtIter(improve(guess, x), x)
  def isGoodEnough(guess: Double, x: Double): Boolean =
  	abs(guess * guess - x) / x < 0.001
  def improve(guess: Double, x: Double): Double =
  	(guess + x / guess) / 2
  sqrtIter(1.0, x)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(12); val res$0 = 
  sqrt(2.0);System.out.println("""res0: Double = """ + $show(res$0));$skip(12); val res$1 = 
  sqrt(4.0);System.out.println("""res1: Double = """ + $show(res$1))}
}
