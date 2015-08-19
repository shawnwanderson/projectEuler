val keyChars = (97 to 122)
val encrChars = scala.io.Source.fromFile("p059_cipher.txt").getLines().next.split(",").toList.map(_.toInt)

def unshuffle(cards: List[Int]): (List[Int], List[Int], List[Int]) = cards.length match {
  case 0 => (Nil, Nil, Nil)
  case 1 => (cards, Nil, Nil)
  case length =>
    val (left, right) = cards.splitAt(length / 2)
    val ((a, b, c), (d, e, f)) = (unshuffle(left), unshuffle(right))
    if (c.length == a.length) (a ::: d, b ::: e, c ::: f)
    else if (b.length == a.length) (a ::: e, b ::: f, c ::: d)
    else (a ::: f, b ::: d, c ::: e)
}

def most(l: List[Int]) = l.groupBy(identity).mapValues(_.size).maxBy(_._2)

//space
32 ^ most(unshuffle(encrChars)._1)._1 
32 ^ most(unshuffle(encrChars)._2)._1
32 ^ most(unshuffle(encrChars)._3)._1

//e
101 ^ most(unshuffle(encrChars)._1)._1 
101 ^ most(unshuffle(encrChars)._2)._1
101 ^ most(unshuffle(encrChars)._3)._1

val a = unshuffle(encrChars)._1.map(c => c ^ 103)
val b = unshuffle(encrChars)._2.map(c => c ^ 111)
val c = unshuffle(encrChars)._3.map(c => c ^ 100)

val all = a ++ b ++ c

all.sum