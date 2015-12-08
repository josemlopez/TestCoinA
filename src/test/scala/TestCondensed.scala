/**
 * Created by jmlopez on 08/12/15.
 */
import org.scalatest.{Matchers, FlatSpec}
import condensedInputProblem._

class SetSpec extends FlatSpec with Matchers{


  "If outputValues is an Empty array" should "return 0" in {
    val input = Array[Long](1)
    input (0) = Long.MaxValue
    getCondensedInputCount(input, Array[Long]()) should be (0)
  }

  it should "return the length of input in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(1L,3L,2L,5L,4L,6L)
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (inputValues.length)
    res should be >0
  }

  it should "return the length of input -1 in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(1L,3L,2L,5L,4L,7L)
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (inputValues.length-1)
    res should be >0
  }

  it should "return the length of input -2 in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(1L,3L,2L,5L,41L,7L)
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (inputValues.length-2)
    res should be >0
  }

  it should "return 0 in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(111L,3L,2L,5L,41L,7L)
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (0)
  }

  it should "return 2 in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(1L,3L,22L,5L,41L,7L)
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (2)
  }

  it should "return 0 in this array of large numbers" in {
    val outputValues: Array[Long] = Array(100001L,20000202L,33838281L,481278127L,58127181278L,69128191L)
    val inputValues: Array[Long] = Array(outputValues.reduce(_+_)+1,20000202L,33838281L,481278127L,58127181278L,69128191L) // this way we are sure about the solution and input.sum > output.sum
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (0)
  }

  it should "return the length of this large array" in {
    val n = 10000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (inputValues.length)
  }

  it should "return the length of this very large array" in {
    val n = 100000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (inputValues.length)
  }

  it should "return the length of this very very large array" in {
    val n = 1000000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (inputValues.length)
  }

  it should "return the length of this very very very large array" in {
    val n = 5000000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (inputValues.length)
  }


  it should "return the length of this very very very large array: 7500000" in {
    val n = 7500000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount(inputValues, outputValues)
    res should be (inputValues.length)
  }

///-----------------------------------

  "getCondensedInputCount2: If outputValues is an Empty array" should "return 0" in {
    val input = Array[Long](1)
    input (0) = Long.MaxValue
    getCondensedInputCount2(input, Array[Long]()) should be (0)
  }

  it should "getCondensedInputCount2: return the length of input in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(1L,3L,2L,5L,4L,6L)
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (inputValues.length)
    res should be >0
  }

  it should "getCondensedInputCount2: return the length of input -1 in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(1L,3L,2L,5L,4L,7L)
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (inputValues.length-1)
    res should be >0
  }

  it should "getCondensedInputCount2: return the length of input -2 in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(1L,3L,2L,5L,41L,7L)
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (inputValues.length-2)
    res should be >0
  }

  it should "getCondensedInputCount2: return 0 in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(111L,3L,2L,5L,41L,7L)
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (0)
  }

  it should "getCondensedInputCount2: return 2 in" in {
    val outputValues: Array[Long] = Array(1L,2L,3L,4L,5L,6L)
    val inputValues: Array[Long] = Array(1L,3L,22L,5L,41L,7L)
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (2)
  }

  it should "getCondensedInputCount2: return 0 in this array of large numbers" in {
    val outputValues: Array[Long] = Array(100001L,20000202L,33838281L,481278127L,58127181278L,69128191L)
    val inputValues: Array[Long] = Array(outputValues.reduce(_+_)+1,20000202L,33838281L,481278127L,58127181278L,69128191L) // this way we are sure about the solution and input.sum > output.sum
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (0)
  }

  it should "getCondensedInputCount2: return the length of this large array" in {
    val n = 10000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (inputValues.length)
  }

  it should "getCondensedInputCount2: return the length of this very large array" in {
    val n = 100000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (inputValues.length)
  }

  it should "getCondensedInputCount2: return the length of this very very large array" in {
    val n = 1000000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (inputValues.length)
  }

  it should "getCondensedInputCount2: return the length of this very very very large array" in {
    val n = 5000000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (inputValues.length)
  }

  it should "getCondensedInputCount2: return the length of this very very very large array: 7500000" in {
    val n = 7500000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).filter (x => x > 0).toArray
    val inputValues = outputValues.clone()
    val res = getCondensedInputCount2(inputValues, outputValues)
    res should be (inputValues.length)
  }

}
