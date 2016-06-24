package engine.pieces

/**
 * Created by jamol on 20/06/16.
 */

import engine.Alliance
import engine.Alliance._
import engine.squares.{Row, Position, Square}

abstract class Piece {

  def alliance:Alliance

  def position:Position

  def canMoveTo(currentState:List[Square],position:Position):Boolean

  def changePosition(position: Position):Piece
}

case class King(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???

  override def changePosition(position: Position): Piece = King(alliance, position)
}


case class Queen(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???

  override def changePosition(position: Position): Piece = Queen(alliance, position)
}



case class Rook(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???

  override def changePosition(position: Position): Piece = Rook(alliance, position)
}



case class Bishop(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???

  override def changePosition(position: Position): Piece = Bishop(alliance, position)
}



case class Knight(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???

  override def changePosition(position: Position): Piece = Knight(alliance, position)
}



case class Pawn(override val alliance: Alliance, override val position: Position) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Position):Boolean = ???

  override def changePosition(position: Position): Piece =
    if((alliance equals Alliance.White) && (position.row equals Row.EIGHT))
      Queen(alliance, position)
    else
      Pawn(alliance, position)
}
