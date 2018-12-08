package recfun

object Main {
  def main(args: Array[String]) {
  /*  println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
*/
   println( countChange(4,List(1,2)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0 || c == r)
        return 1

      pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceBrackets(chars: List[Char], openProjects: Int): Boolean ={
        if(chars.isEmpty)
          return openProjects == 0

        if(openProjects < 0)
          return false

        if(chars.head == '(')
          balanceBrackets(chars.tail, openProjects + 1)
        else if(chars.head == ')')
          balanceBrackets(chars.tail, openProjects -1)
        else
          balanceBrackets(chars.tail, openProjects )
      }

      balanceBrackets(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

      def denominator(i: Int, j: Int, coins: List[Int]): Int= {

        println(s"${i},${j}")

        if(j == 0 || i == 0)
          return  1

        if(j >= coins(i)) {
          println(s"coin: ${coins(i)} j: ${j}")
          return denominator(i - 1, j, coins) + denominator(i, j-coins(i), coins)
        }
        else{
          return denominator(i-1, j,  coins)
        }
      }

      println("test")
      denominator(coins.length-1, money, coins.reverse)
    }

  }
