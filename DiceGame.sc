import java.util.concurrent.ThreadLocalRandom
//Solution for 2.a
def random = ThreadLocalRandom.current.nextInt(1, 7)

//Solution for 2.b
def totalPayout(numberOfPlays: Int, total: Int = 0): Int = {
  val diceSide = random
  if(numberOfPlays > 0) totalPayout(numberOfPlays - 1, total + diceSide)
  else total
}

//Solution for 2.c
//Used the simple average calculation of averagePayoutPerGame = totalPayout for all plays per game divide by number of plays per game
def averagePayout(numberOfGames: Int, playsPerGame: Int, averagePayoutsPerGame: List[Int] = List.empty): Double = {
  var averagePerGame = 0
  if(numberOfGames > 0)
    averagePayout(numberOfGames - 1, playsPerGame, averagePayoutsPerGame :+ averagePerGame)
  else
    totalPayout(playsPerGame) / playsPerGame
}
