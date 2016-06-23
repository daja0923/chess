package engine.moves

import engine.pieces.Piece
import engine.squares.Position

/**
 * Created by jamol on 23/06/16.
 */
case class Check(override val piece: Piece,
                  override val dest:Position,
                  attacked:Option[Piece] = None) extends Move{

}
