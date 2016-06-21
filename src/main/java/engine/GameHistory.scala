package engine

import engine.pieces.Piece
import engine.positions.Square

/**
 * Created by jamol on 20/06/16.
 */
class GameHistory( moves:List[Move]) {

  val initialState:State = start



  def start:State = Square.start



  type State = List[Square]



  def endState:State = trackState(initialState, moves.reverse)



  def trackState(state: State, moves: List[Move]):State = {
    if(moves.isEmpty) state
    else trackState(changeState(state, moves.head), moves.tail)
  }



  def changeState(current:State, move: Move):State = {
    val square = current.find(s => s.position equals move.dest).get
    current.map { s =>
      if (s.position equals move.dest) s.copy(position = move.dest)
      else if(piecesTheSame(s.piece, move.removed)) s.copy(piece = None)
      else s
    }
  }


  def piecesTheSame(piece1:Option[Piece], piece2:Option[Piece]):Boolean =
    (piece1, piece2) match {
      case (None, _) => false
      case (_, None) => false
      case (Some(p1), Some(p2)) => p1 equals p2
    }
}
