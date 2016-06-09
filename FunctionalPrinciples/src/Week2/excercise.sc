package Week2

object excercise {
  def Factorial(n: Int): Int = {
  	def loop(acc: Int, n: Int): Int =
  		if (n == 0) acc
  		else loop(acc * n, n - 1)
  	loop(1, n)
  }                                               //> Factorial: (n: Int)Int
  Factorial(4)                                    //> res0: Int = 24
}