//Stream.from(1).take(1000).map(n => n.toDouble).reduce((a, b) => (math.pow(a, a) % BigInt("10000000000").toDouble).toDouble + (math.pow(b, b) % BigInt("10000000000").toDouble).toDouble)

def pow(a: Double, p: Double, m: Double = 10000000000D): Double = {
	p match {
		case 1 => a
		case power => (a % m) * (pow(a, power - 1) % m)
	}
}

(1 to 1000).map(n => pow(n, n) % 10000000000D).sum % 10000000000D
