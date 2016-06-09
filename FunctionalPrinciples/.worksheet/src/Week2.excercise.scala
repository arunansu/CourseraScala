package Week2

object excercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(171); 
  def Factorial(n: Int): Int = {
  	def loop(acc: Int, n: Int): Int =
  		if (n == 0) acc
  		else loop(acc * n, n - 1)
  	loop(1, n)
  };System.out.println("""Factorial: (n: Int)Int""");$skip(15); val res$0 = 
  Factorial(4);System.out.println("""res0: Int = """ + $show(res$0))}
}
