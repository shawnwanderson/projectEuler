
/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

def Collatz(n: Long, ind: Int = 1): Int = 
	if(n == 1) ind else 
		n%2 match {
			case 0 => Collatz(n/2, ind + 1)
			case 1 => Collatz(3*n + 1, ind + 1)
			case _ => println(n); 1
		}
val big = (1 to 1000000).map(Collatz(_)).reduceLeft((a, b) => if (a>b) a else b)


