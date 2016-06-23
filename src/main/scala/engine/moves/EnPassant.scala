package engine.moves

import engine.Alliance
import engine.pieces.{Pawn, Piece}
import engine.squares.Rank.Rank
import engine.squares.{Position, Row}

/**
 * Created by jamol on 23/06/16.
 */



case class EnPassant(override val piece: Piece,
                     override val dest:Position,
                     attackedPawn:Piece) extends Move{

  assert(isEnPassant(piece, attackedPawn))


  def isEnPassant(attacker:Piece, attacked:Piece):Boolean ={
    val white = Alliance.White
    val black = Alliance.Black
    (attacker, attacked) match {
      case (Pawn(`white`, Position(r1:Rank, Row.FIVE)),
            Pawn(`black`, Position(r2:Rank, Row.FIVE))) =>
            math.abs(r1.id - r2.id) == 1

      case (Pawn(`black`, Position(r1:Rank, Row.FOUR)),
          Pawn(`white`, Position(r2:Rank, Row.FOUR))) =>
          math.abs(r1.id - r2.id) == 1

      case _ => false
    }
  }

  override def attacked: Option[Piece] = Some(attackedPawn)
}
