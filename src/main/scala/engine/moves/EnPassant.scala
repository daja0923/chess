package engine.moves

import engine.pieces.Piece
import engine.squares.Coord

/**
 * Created by jamol on 23/06/16.
 */



case class EnPassant(override val piece: Piece,
                     override val source:Coord,
                     override val dest:Coord,
                     attackedPawn:Piece) extends Move{


  override def attacked: Option[Piece] = Some(attackedPawn)
}
