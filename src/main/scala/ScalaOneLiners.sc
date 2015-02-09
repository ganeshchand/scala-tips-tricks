/**
 * @author Ganesh Chand
 *
 */

/* Most useful Scala One-liners */

/**
 * 1. Multiply each item in a list by 2
 *
 * */

(1 to 10).map(_ * 2) // you can also write it as (1 to 10) map { _ * 2 }
/**
 * 2. Sum/Max/Min of a List of Numbers
 *
 * */


(1 to 10).reduceLeft(_ + _) // you can also use the built-in function (1 to 100).sum

(1 to 10).max
(1 to 10).min

/* Using reduceLeft, you can pass a function to do advance processing
For example, sum of only even number between 1 to  100
 */

(1 to 10).filter(_ % 2 == 0).reduceLeft(_ + _)


/**
 * 3. Read a File
 *
 * */


//val fileText = io.Source.fromFile("ScalaOneLiners.sc")

val fileText = io.Source.fromFile("/Users/Shared/gmcbookproroot/gh/gc/projects/scala/scala-tips-tricks/build.sbt").mkString
val fileInes = io.Source.fromFile("/Users/Shared/gmcbookproroot/gh/gc/projects/scala/scala-tips-tricks/build.sbt").getLines().toList


/**
 * 4. Happy Birthday to you
 *
 * */

(1 to 4).map {
  i => "Happy Birthday" + (if (i == 3) "dear Name" else "to you")
}.foreach(println)


//
//
//import sys.process._
//"echo ~" !
//
//
////"ls -al" !
//"cat > ~/scala-tmp.txt" !
//
//
////
////cat > /usr/tmp/scala-tmp.txt
