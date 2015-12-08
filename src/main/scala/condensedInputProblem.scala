/**
 * Created by jmlopez on 08/12/15.
 */
class condensedInputProblem {

}

object condensedInputProblem {
  def time[A](f: => A) = {
    val s = System.nanoTime
    val ret = f
    println("time: "+(System.nanoTime-s)/1e6+"ms")
    ret
  }

  def main(args: Array[String]): Unit = {

    println("---------------------------")
    val n = 10000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount(inputValues, outputValues)
    println(res)


  }

  ////-------

  /**
   * Calculates an adjusted number of input values that is reduced from the original size of
   * 'inputValues' when any output values must consume multiple input values.
   *
   * @param inputValues An array of input values being spent in a transaction.
   * @param outputValues An array of output values being received in a transaction.
   *
   * @return The adjusted number of inputs.
   */
  def getCondensedInputCount(inputValues:Array[Long], outputValues:Array[Long]): Int = {
    // using BigInt, this way we will have not problems with the SUM
    val sumOut: BigInt = {
      if (outputValues.nonEmpty) {
        outputValues.foldLeft[BigInt](BigInt (0L))((a, b) => a + BigInt (b))
      } else {
        return 0
      }
    }
    var index = 0
    var sumInput = BigInt(0L)
    while (index < inputValues.length) {
      sumInput += BigInt(inputValues(index))
      if (sumInput > sumOut) {

        return index
      }
      index += 1
    }
    index
  }

}
