package engine.moves

import engine.pieces.{Queen, Pawn, Piece}
import engine.squares.Position

/**
 * Created by jamol on 23/06/16.
 */
case class Promotion(pawn: Pawn,
                     override val source:Position,
                     override val dest:Position,
                     override val captured:Option[Piece] = None) extends SingleMove(Queen(pawn.alliance), source, dest){
}
