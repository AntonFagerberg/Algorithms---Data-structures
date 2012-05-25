/* Insert sort with Scala generics.
 * Implemented by Anton Fagerberg 2012.
 *
 * Class: Sorting algorithm
 * Data structure: Array (Seq trait in Scala)
 * Worst case performance: O(n^2)
 * Best case performance: O(n)
 * Average case performance: O(n^2)
 * Worst case space complexity: O(n) total, O(1) auxiliary
 */ 
object InsertionSort {
  def main(args: Array[String]) {
    println(insertionSort(Seq(2, 8, 6, 1, 2, -1, -4, 5, 99, 83, 7)))
  }

  def insertionSort[T](numbers: Seq[T])(implicit n: Numeric[T], t: ClassManifest[T]): Seq[T] = {
    var sortNumbers = new scala.collection.mutable.ArrayBuffer() ++ numbers
    var changeIndex = -1

    1.to(sortNumbers.length - 1).foreach { i =>
      changeIndex = i

      while (changeIndex > 0 && n.lt(sortNumbers(i), sortNumbers(changeIndex - 1))) {
        changeIndex -= 1
      }

      sortNumbers.insert(changeIndex, sortNumbers.remove(i))
    }

    sortNumbers
  }
}