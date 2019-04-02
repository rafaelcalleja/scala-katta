package katta.TennisGame

import scala.language.implicitConversions

case class Player (var name: String, var gamePoint: GamePoint) {
  def winBall(): Unit = {
    gamePoint = GamePoint(gamePoint.point + 1)
  }

  def score(): Int = gamePoint.point
}

object Player {
  def apply(name: String) = new Player(name, GamePoint(0))
}
