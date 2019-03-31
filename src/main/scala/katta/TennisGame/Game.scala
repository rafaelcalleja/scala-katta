package katta.TennisGame

case class Game (PlayerA: Player, PlayerB: Player, Score: Score)

object Game {
  def apply(PlayerA: Player, PlayerB: Player) = new Game(PlayerA, PlayerB, new Score)
}
