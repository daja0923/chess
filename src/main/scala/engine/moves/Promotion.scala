package engine.moves

import engine.pieces.{Queen, Pawn, Piece}
import engine.squares.Coord

/**
 * Created by jamol on 23/06/16.
 */
case class Promotion(pawn: Pawn,
                     override val source:Coord,
                     override val dest:Coord,
                     override val attacked:Option[Piece] = None) extends Move{
  override def piece: Piece = Queen(pawn.alliance)
}
