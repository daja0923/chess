package engine.pieces

/**
 * Created by jamol on 20/06/16.
 */
import engine.Alliance._
import engine.positions.{Square, Position}

abstract class Piece {

  def alliance:Alliance

  def position:Position

  def canMoveTo(currentState:List[Square],position:Position):Boolean
}

case class King(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???
}


case class Queen(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???
}



case class Rook(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???
}



case class Bishop(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???
}



case class Knight(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???
}



case class Pawn(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???
}
