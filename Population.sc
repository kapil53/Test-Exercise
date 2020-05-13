//Solution for 1.a
def random = ThreadLocalRandom.current.nextInt(1, 3)

//Solution for 1.b
def generateCollectionOfInts(index: Int, result: List[Int] = List.empty[Int]): List[Int] = {
  val newR = random
  if(index == 1 || newR == 2) {
   result :+ newR
  } else {
    generateCollectionOfInts(index - 1, result :+ newR)
  }
}

//Solution for 1.c
def repeatCallOfGenerateWithRatio() = {
  val (ones, twos) = Seq.fill(1000)(generateCollectionOfInts(50))
    .flatten.toList.partition(_ == 1)

  val ratioOfTwosAndOnes = twos.size/ones.size

  ratioOfTwosAndOnes
}
