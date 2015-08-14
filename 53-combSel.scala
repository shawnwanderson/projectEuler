//How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?

def fact(n: Long): Long = n match {
	case 0 => return 1L
	case _ => return (n * fact(n - 1L))
}

def choose(n: Int, r: Int): Double = (1 to n).drop(r).map(_.toDouble).product / (1 to (n-r)).map(_.toDouble).product

(23 to 100).map(n => (1 to n).zip(List.fill(n)(n))).map(_.takeWhile (t => choose(t._2, t._1) < 1000000) ).map(_.last).map(t => t._2 - 2*t._1 - 1).sum