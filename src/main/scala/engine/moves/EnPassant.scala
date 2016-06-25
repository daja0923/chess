package engine.moves

import engine.pieces.{Pawn, Piece}
import engine.squares.Position

/**
 * Created by jamol on 23/06/16.
 */



case class EnPassant(override val piece: Piece,
                     override val source:Position,
                     override val dest:Position,
                     capturedPawn:Pawn) extends SingleMove(piece, source, dest){


  override def captured: Option[Piece] = Some(capturedPawn)
}
