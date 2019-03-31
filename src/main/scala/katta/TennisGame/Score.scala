package katta.TennisGame

case class Score()

object Score {
  type ScoreType = Map[Int, String]

  //val MapScore = List(ScoreType(0, "0"), ScoreType(1, "15"), Map)

}

case class GamePoint(point: Int, value: String, score: String) extends {
  override def toString: String = score
}

object GamePoint {
  def apply(point: Int): GamePoint = point match {
    case 0 => new GamePoint(point, "0", "love")
    case 1 => new GamePoint(point, "15", "fifteen")
    case 2 => new GamePoint(point, "30", "thirty")
    case 3 => new GamePoint(point, "40", "forty")
    case 4 => new GamePoint(point, "AD", "advantage")
  }
}

case class ScorePoint(ServiceGamePoint: GamePoint, RestGamePoint: GamePoint) extends {
  override def toString: String = {
    var s: String = List(ServiceGamePoint, RestGamePoint)
    s
  }
}

object ScorePoint {
  implicit def Scores2String(scores: List[GamePoint]): String = {
    "AAAA"
  }

  def apply(servicePoint: Int, restPoint: Int): ScorePoint = new ScorePoint(GamePoint(servicePoint), GamePoint(restPoint))
}





