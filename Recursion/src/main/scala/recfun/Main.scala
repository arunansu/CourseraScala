package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1: Pascal’s Triangle
   * The following pattern of numbers is called Pascal’s triangle.
   *    1
   *   1 1
   *   1 2 1
   *  1 3 3 1
   * 1 4 6 4 1
   *    ...
   * The numbers at the edge of the triangle are all 1, 
   * and each number inside the triangle is the sum of the two numbers above it. 
   * Write a function that computes the elements of Pascal’s triangle 
   * by means of a recursive process.
   * For example, pascal(0,2)=1,pascal(1,2)=2 and pascal(1,3)=3.
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1 
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  
  /**
   * Exercise 2: Parentheses Balancing
   * Write a recursive function which verifies the balancing of parentheses in a string, 
   * which we represent as a List[Char] not a String. For example, 
   * the function should return true for the following strings:
   * (if (zero? x) max (/ 1 x))
   * I told him (that it’s not (yet) done). (But he wasn’t listening)
   * and false for 
   * :-)
   * ())(
   */
    def balance(chars: List[Char]): Boolean = {
      def isBalanced(chars: List[Char], count: Int): Boolean = {
        if (chars.isEmpty) {
          count == 0
        }
        else {
          val first = chars.head
          val n = 
            if (first == '(') count + 1
            else if (first == ')') count - 1
            else count
          if (n >= 0) isBalanced(chars.tail, n)
          else false
        }
      }
      isBalanced(chars, 0)
    }
  
  /**
   * Exercise 3: Counting Change
   * Write a recursive function that counts how many different ways you can make change 
   * for an amount, given a list of coin denominations. For example, 
   * there are 3 ways to give change for 4 if you have coins with denomiation 1 and 2: 
   * 1+1+1+1, 1+1+2, 2+2.
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def countChange(lastMaxCoin_total_coll: List[(Int, Int)], count: Int): Int = {
      if (lastMaxCoin_total_coll.isEmpty) {
        count
      } else {
        val b = scala.collection.mutable.ListBuffer[(Int, Int)]()
        var newCount = count
        for ((lastMaxCoin, total) <- lastMaxCoin_total_coll) {
          if (total < money) {
            for (c <- coins) {
              if (c >= lastMaxCoin) {
                val e = (c, total + c)
                b += e
              }
            }
          } else if (total == money) {
            newCount += 1
          }
        }

        countChange(b.toList, newCount)
      }
    }

    val b = coins.map { c => (c, c) }
    countChange(b, 0)
  }
 }
