package engine.moves

import engine.pieces.Piece
import engine.squares.Position

/**
 * Created by jamol on 23/06/16.
 */
case class SimpleMove(override val piece: Piece,
                      override val source:Position,
                      override val dest:Position,
                      override val attacked:Option[Piece] = None) extends Move {
}
