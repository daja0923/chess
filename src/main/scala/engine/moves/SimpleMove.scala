package engine.moves

import engine.pieces.Piece
import engine.squares.Coord

/**
 * Created by jamol on 23/06/16.
 */
case class SimpleMove(override val piece: Piece,
                      override val source:Coord,
                      override val dest:Coord,
                      override val attacked:Option[Piece] = None) extends Move {
}
