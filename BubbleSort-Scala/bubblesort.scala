/* Bubble sort with Scala generics.
 * Implemented by Anton Fagerberg 2012.
 *
 * Class: Sorting algorithm
 * Data structure: Array (Seq trait in Scala)
 * Worst case performance: O(n^2)
 * Best case performance: O(n)
 * Average case performance: O(n^2)
 * Worst case space complexity: O(1) auxiliary
 */ 
object BubbleSort {
  def main(args: Array[String]) {
    println(bubbleSort(Seq(2, 8, 6, 1, 2, -1, -4, 5, 99, 83, 7)))
  }

  def bubbleSort[T](numbers: Seq[T])(implicit n: Numeric[T], t: ClassManifest[T]): Seq[T] = {
    if (numbers.length < 2) {
      numbers
    } else {
      var sortNumbers = numbers.toArray
      var sortedTo = numbers.length - 2
      var allSorted = false
      var diff = n.zero

      while (!allSorted) {
        allSorted = true

        0.to(sortedTo).foreach { i =>
          diff = n.minus(sortNumbers(i), sortNumbers(i + 1))

          if (n.gt(diff, n.zero)) {
            sortNumbers(i) = n.minus(sortNumbers(i), diff)
            sortNumbers(i + 1) = n.plus(sortNumbers(i + 1), diff)
            sortedTo = i - 1
            allSorted = false
          }
        }
      }

      sortNumbers
    }
  }
}