package engine.moves

import engine.pieces.{Queen, Pawn, Piece}
import engine.squares.Position

/**
 * Created by jamol on 23/06/16.
 */
case class Promotion(pawn: Pawn,
                     override val dest:Position,
                     override val attacked:Option[Piece] = None) extends Move{
  override def piece: Piece = Queen(pawn.alliance, dest)
}
