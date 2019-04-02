package katta.TennisGame

class TennisGame(PlayerA: Player, PlayerB: Player) {
  def score(): String = {
    val currentScore: ScorePoint = ScorePoint(PlayerA.gamePoint, PlayerB.gamePoint)

    if (currentScore.serviceHasMaxScore) {
      return currentScore.replace("service", PlayerA.name)
    }

    currentScore.replace("rest", PlayerB.name)
  }
}
