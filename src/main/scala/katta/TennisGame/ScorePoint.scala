package katta.TennisGame

case class ScorePoint(ServiceGamePoint: GamePoint, RestGamePoint: GamePoint) extends {
  val totalGamePoint: Int = ServiceGamePoint.point + RestGamePoint.point
  val maxScore: Int = Seq(ServiceGamePoint.point, RestGamePoint.point).max
  val minScore: Int = Seq(ServiceGamePoint.point, RestGamePoint.point).min

  def isGameOver: Boolean = {
    if (maxScore < 4 && minScore < 4)
      return false

    if (maxScore - minScore < 2 && maxScore >= 4)
      return false

    true
  }

  def gameIsTie: Boolean = this.ServiceGamePoint.point == this.RestGamePoint.point
  def serviceHasMaxScore: Boolean = maxScore == ServiceGamePoint.point
  def restHasMaxScore: Boolean = maxScore == RestGamePoint.point

  override def toString: String = {
    if (isGameOver && serviceHasMaxScore)
      return "service won"

    if (isGameOver && restHasMaxScore)
      return "rest won"

    if (this.totalGamePoint < 6) {
      return this.ServiceGamePoint.score + ", " + this.RestGamePoint.score
    }

    if (gameIsTie){
      return "deuce"
    }

    if (serviceHasMaxScore) {
      return "advantage service"
    }

    "advantage rest"
  }
}

object ScorePoint {
  implicit def Scores2String(scorePoint: ScorePoint): String = {
    scorePoint.toString
  }

  def apply(servicePoint: Int, restPoint: Int): ScorePoint = new ScorePoint(GamePoint(servicePoint), GamePoint(restPoint))
}
