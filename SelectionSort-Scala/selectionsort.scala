/* Select sort with Scala generics.
 * Implemented by Anton Fagerberg 2012.
 *
 * Class: Sorting algorithm
 * Data structure: Array (Seq trait in Scala)
 * Worst case performance: O(n^2)
 * Best case performance: O(n^2)
 * Average case performance: O(n^2)
 * Worst case space complexity: O(n) total, O(1) auxiliary
 */ 
object SelectionSort {
  def main(args: Array[String]) {
    println(selectionSort(Seq(2, 8, 6, 1, 2, -1, -4, 5, 99, 83, 7)))
  }

  def selectionSort[T](numbers: Seq[T])(implicit n: Numeric[T], t: ClassManifest[T]): Seq[T] = {
    var sortNumbers = numbers.toArray
    var startIndex = 0;
    var switchIndex = 0
    var minimalValue = n.fromInt(Int.MaxValue)
    var temp = n.zero

    while (startIndex < sortNumbers.length) {
      startIndex.to(sortNumbers.length - 1).foreach { i =>
        if (n.gt(minimalValue, sortNumbers(i))) {
          minimalValue = sortNumbers(i)
          switchIndex = i
        }
      }

      sortNumbers(switchIndex) = sortNumbers(startIndex)
      sortNumbers(startIndex) = minimalValue
      minimalValue = n.fromInt(Int.MaxValue)
      startIndex += 1
    }

    sortNumbers
  }
}