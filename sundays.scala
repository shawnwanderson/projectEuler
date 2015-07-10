
class date(val year: Int = 1901, var month: Int = 1, val monthDay: Int = 1, var weekDay: Int = 3){
	if (month == 0) month = 12
	if (weekDay == 0) weekDay = 7
	override def toString: String = s"$year / Month: $month the $monthDay / $weekDay day of the week"
	def equals(that: date): Boolean = this.year == that.year && this.month == that.month && this.monthDay == that.monthDay && this.weekDay == that.weekDay
	val leap: Boolean = if(year%4 == 0 && (year%100 != 0  || year%400 == 0)) true else false
	val monthDays: Int = this.month match {
		case n if List(9, 4, 6, 11).contains(n) => 30
		case n if List(1, 3, 5, 7, 8, 10, 12).contains(n) => 31
		case n if n == 2 && this.leap => 29
		case _ => 28
	}
	def next(): date = {
		val y = if(month == 12 && monthDay == monthDays) this.year + 1 else this.year
		val m = if(monthDay == monthDays) (this.month + 1)%12 else this.month
		val md = if(monthDay == monthDays) 1 else this.monthDay + 1
		val wd = (this.weekDay + 1)%7
		new date(y, m, md, wd)
	}
}

val fin = new date(2000, 12, 31, 1)
def countSundays(d: date, sum: Int = 0): Int = {
	println(d)
	if(d equals fin) return sum + 1
	if(d.monthDay == 1 && d.weekDay == 1) countSundays(d.next, sum + 1) else countSundays(d.next, sum)
}