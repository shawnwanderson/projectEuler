/*

In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?
*/

import scala.collection.mutable.ListBuffer

val mem = new ListBuffer[Int]
/*
for(i <- (0 to 200))yield { i match {
	case n if (n >= 200) => mem.insert(n, mem(n - 200) + mem(n - 100) + mem(n - 50) + mem(n - 20) + mem(n - 10) + mem(n - 5) + mem(n - 2) + mem(n - 1))
	case n if (n >= 100) => mem.insert(n, mem(n - 100) + mem(n - 50) + mem(n - 20) + mem(n - 10) + mem(n - 5) + mem(n - 2) + mem(n - 1))
	case n if (n >= 50)  => mem.insert(n, mem(n - 50) + mem(n - 20) + mem(n - 10) + mem(n - 5) + mem(n - 2) + mem(n - 1))
	case n if (n >= 20)  => mem.insert(n, mem(n - 20) + mem(n - 10) + mem(n - 5) + mem(n - 2) + mem(n - 1))
	case n if (n >= 10)  => mem.insert(n, mem(n - 10) + mem(n - 5) + mem(n - 2) + mem(n - 1))
	case n if (n >= 5)   => mem.insert(n, mem(n - 5) + mem(n - 2) + mem(n - 1))
	case n if (n >= 2)   => mem.insert(n, mem(n - 2) + mem(n - 1))
	case n if (n > 1)    => mem.insert(n, mem(n - 1))
	case n if (n <= 1)   => mem.insert(n, 1)
}} */

val S = List(1, 2, 5, 10, 20, 50, 100, 200).reverse
val m = 8
val n = 200

def calc(S: List[Int], m: Int, n: Int): Int = {
	if (n == 0) return 1
	if (n < 0)  return 0
	if (m <= 0) return 0
	return calc(S, m-1, n) + calc(S, m, n - S(m-1))
}