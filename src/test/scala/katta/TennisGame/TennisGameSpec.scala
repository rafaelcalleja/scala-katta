package katta.TennisGame

import katta.UnitSpec

class TennisGameSpec extends UnitSpec {

    "Test" should "be tetes" in {
    }

    "Player" should "had names" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")

      victor.name should be ("Victor")
      sarah.name should be ("Sarah")
    }

    "Score" should "be empty when start" in {
      val score = Score
      score.toString should be ("0, 0")
    }

    "GamePoint" should "be game points" in {
      GamePoint(0).toString should be ("love")
      GamePoint(1).toString should be ("fifteen")
      GamePoint(2).toString should be ("thirty")
      GamePoint(3).toString should be ("forty")
      GamePoint(4).toString should be ("advantage")
    }

    "ScorePoint" should "be score points" in {
      ScorePoint(0, 0).toString should be ("love, love")
      ScorePoint(1, 3).toString should be ("fifteen, forty")
      ScorePoint(3, 3).toString should be ("deuce")
      ScorePoint(5, 4).toString should be ("advantage service")
      ScorePoint(6, 7).toString should be ("advantage rest")
      ScorePoint(10, 10).toString should be ("deuce")
    }

    /*"Score" should "be finish with clean score" in {
      val score = Score
      score.serviceGoal()
      score.serviceGoal()
      score.serviceGoal()
      score.toString() should be ("40, 0")
    }

    "Score" should "be finish with deuce score" in {
      val score = Score
      score.serviceGoal()
      score.serviceGoal()
      score.serviceGoal()

      score.restGoal()
      score.restGoal()
      score.restGoal()

      score.toString() should be ("Deuce")
    }*/

    /*"Points" can "be added to each player" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")
      val game = new TennisGame(victor, sarah)
      victor.winBall
      victor.winBall
      sarah.winBall
      victor.winBall
      victor.score should be (3)
      sarah.score should be (1)
    }

    "Love" should "be description for score 0" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")
      val game = new TennisGame(victor, sarah)
      game.score should be ("love, love")
    }

    "Fifteen" should "be description for score 1" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")
      val game = new TennisGame(victor, sarah)
      sarah.winBall
      game.score should be ("love, fifteen")
    }

    "Thirty" should "be description for score 2" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")
      val game = new TennisGame(victor, sarah)
      victor.winBall
      victor.winBall
      sarah.winBall
      game.score should be ("thirty, fifteen")
    }

    "Forty" should "be description for score 3" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")
      val game = new TennisGame(victor, sarah)
      (1 to 3).foreach(x => victor.winBall)
      game.score should be ("forty, love")
    }

    "Advantage" should "describe when least three points have been scored by each side and a player has one more point than his opponent" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")
      val game = new TennisGame(victor, sarah)
      (1 to 3).foreach(x => victor.winBall)
      (1 to 4).foreach(x => sarah.winBall)
      game.score should be ("advantage Sarah")
    }

    "Deuce" should "be description when at least three points have been scored by each player and the scores are equal" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")
      val game = new TennisGame(victor, sarah)
      (1 to 3).foreach(x => victor.winBall)
      (1 to 3).foreach(x => sarah.winBall)
      game.score should be ("deuce")
      victor.winBall
      game.score should not be "deuce"
      sarah.winBall
      game.score should be ("deuce")
    }

    "Game" should "be won by the first player to have won at least four points in total and with at least two points more than the opponent" in {
      val victor = Player("Victor")
      val sarah = Player("Sarah")
      val game = new TennisGame(victor, sarah)
      (1 to 4).foreach(x => victor.winBall)
      (1 to 3).foreach(x => sarah.winBall)
      game.score should not be "Victor won"
      game.score should not be "Sarah won"
      victor.winBall
      game.score should be ("Victor won")
    }*/

  }
