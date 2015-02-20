package programminginscala.functionalobjects

/**
 * Created by ganeshchand on 2/19/15.
 */
/**
 * Used to create rational number: It is a number that can be expressed as a ration of n/d,
 * where n and d are integers, except d cannot be zero
 * Where possible, rational numbers will be normalized. Eg. 66/42 = 11/7. This requires finding gcd and dividing n and d by gcd
 * @param n
 *            numerator is an integer, n can be zero
 *            client can also pass only numerator, in which is case, it is assumed that denominator is 1 because 4/1 = 1
 * @param d denominator is an integer, d cannot be zero
 */
class Rational(n: Int, d: Int){
  require(d > 0, "denominator cannot be zero") // throws IllegalArgumentException if d is passed as zero and object construction will fail.
  private val g = gcd(n.abs,d.abs) // to ensure g is always positive, pass absolute values
  val numer: Int = n/g
  val denom: Int = d/g


  def this(n: Int) = this(n,1) // auxiliary constructor - passes a single parameter and default value of 1 to primary constructor
  override def toString = numer +"/"+ denom

  def add(that: Rational): Rational ={
    new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom) // you may choose not to use this keyword
    // this is an object instance on which the add method is invoked.
    // that is an object passed as a parameter
  }

  def lessThan(that: Rational): Boolean ={
    this.numer * that.denom < that.numer * this.denom
  }

  def greaterThan(that: Rational): Boolean ={
    if(this.lessThan(that)) false else true
  }

  def max(that: Rational): Rational ={
    if(this.lessThan(that)) that else this
  }

  def min(that: Rational): Rational ={
    if(this.lessThan(that)) this else that
  }

  /*
  Find the greatest common divisor of two values
   */
  private def gcd(a: Int, b: Int): Int = {
    if(b ==0) a else gcd(b, a % b)
  }

}

object Rational{
  def main(args: Array[String]) {
    val oneHalf = new Rational(1,2)
    println(oneHalf)
    val twoThird = new Rational(2,3)
    println(twoThird)
//    val oneZero = new Rational(1,0)

    val result = oneHalf.add(twoThird)
    println(result)

    println(oneHalf.lessThan(twoThird)) // returns true
    println(oneHalf.greaterThan(twoThird)) // returns false
    println(oneHalf.max(twoThird)) // returns 2/3
    println(oneHalf.min(twoThird)) // returns 1/2

    println(new Rational(42,56)) // gcd is 14 so normalized rational number is 3/4
  }

}
