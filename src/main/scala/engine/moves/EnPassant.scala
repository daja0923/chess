package engine.moves

import engine.pieces.Piece
import engine.squares.Position

/**
 * Created by jamol on 23/06/16.
 */



case class EnPassant(override val piece: Piece,
                     override val source:Position,
                     override val dest:Position,
                     attackedPawn:Piece) extends Move{


  override def attacked: Option[Piece] = Some(attackedPawn)
}
