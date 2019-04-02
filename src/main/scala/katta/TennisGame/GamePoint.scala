package katta.TennisGame

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
    case _ => new GamePoint(point, point.toString, point.toString)
  }
}
