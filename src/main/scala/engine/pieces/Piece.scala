package engine.pieces

/**
 * Created by jamol on 20/06/16.
 */

import engine.Alliance._
import engine.squares.{Coord, Square}

abstract class Piece {

  def alliance:Alliance

  def canMoveTo(currentState:List[Square],position:Coord):Boolean

}

case class King(override val alliance: Alliance) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Coord):Boolean = ???

}


case class Queen(override val alliance: Alliance) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Coord):Boolean = ???

}



case class Rook(override val alliance: Alliance) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Coord):Boolean = ???

}



case class Bishop(override val alliance: Alliance) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Coord):Boolean = ???

}



case class Knight(override val alliance: Alliance) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Coord):Boolean = ???
}



case class Pawn(override val alliance: Alliance) extends Piece {
  override def canMoveTo(currentState:List[Square],position:Coord):Boolean = ???
}
