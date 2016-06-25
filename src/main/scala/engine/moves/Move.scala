package engine.moves

import engine.pieces.Piece
import engine.squares.Position

/**
 * Created by jamol on 20/06/16.
 */
sealed trait Move {

  def time:Long = System.currentTimeMillis()

  def piece:Piece

  def source:Position

  def dest:Position
  

  def captured:Option[Piece]

}



abstract class SingleMove(override val piece: Piece,
                      override val source:Position,
                      override val dest:Position) extends Move{

}


final case class Castle(kingMove:SimpleMove, rookMove:SimpleMove) extends Move{

  override def piece: Piece = throw new NoSuchElementException("piece of Castle")

  override def captured: Option[Piece] = None

  override def source: Position = throw new NoSuchElementException("source of Castle")

  override def dest:Position = throw new NoSuchElementException("dest of Castle")
}
