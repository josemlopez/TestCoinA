#### TestCoinA

- The two solutions supported 10.000.000 of elements in each array (input and output) in a WM with 250MB of memory.
- The solution with BigInt is x5 faster in the worst possible case (all the records in input array are affected)

With this execution plan:

    println("---------------------------")
    val n = 10000000
    val outputValues: Array[Long] = Seq.fill (n)(scala.util.Random.nextLong ()).map( x => if (x < 0) {x*(-1)} else {x}).toArray
    val inputValues = outputValues.clone()
    inputValues(0) = inputValues(0)+1
    var res: Int = 0

    println("Times for solution with BigInt: ")
    res = 0
    for (i <- 1 to 3){
      res = time{getCondensedInputCount(inputValues, outputValues)}
    }
    println(res)

    println("Times for solution with List: ")
    for (i <- 1 to 3){
      res = time{getCondensedInputCount2(inputValues, outputValues)}
    }
    println(res)
    
We have:

#### Times for solution with BigInt: 
- `time:`- 1951.745ms
- `time:`- 1122.173ms
- `time:`- 1050.389ms
- `Reduction:`- 9999999

#### Times for solution with List: 
- `time:`-7187.701ms
- `time:`-6162.138ms
- `time:`-4378.99ms
- `Reduction:`-9999999

