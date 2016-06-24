package engine

import engine.moves.Move
import engine.pieces.Piece
import engine.squares.Rank.Rank
import engine.squares.Row.Row
import engine.squares.{Position, Square}

/**
 * Created by jamol on 22/06/16.
 */
object StateTracker {

  type State = List[Square]

  /**
   * tracks from given state the end of the moves
   * Note moves must be in in order (first move on head, etc)
   * @param state  List[Square]
   * @param moves  List[Move]
   * @return Returns the end state of squares
   */
  @scala.annotation.tailrec
  def trackState(state: State, moves: List[Move]):State =
    moves match {
      case Nil => state
      case m::ms => trackState(changeState(state, m), ms)
  }




  def changeState(current:State, move: Move):State ={
    current.map { square =>
      if(square.position equals move.source)
        square.copy(piece = None) //clear the source square
      else if (square.position equals move.dest)
        square.copy(piece = Some(move.piece)) // update the dest square with the moving piece
      else if(piecesTheSame(square.piece, move.attacked))
        square.copy(piece = None) //clearing attacked piece square explicitly because it is not always destination square
      else square
    }
  }



  def square(state: State, position: Position):Square = {
    val squareOption = state.find(_.position equals position)
    if(squareOption.isEmpty)
      throw new NoSuchElementException("square at position " + position)
    else
      squareOption.get
  }


  def square(state:State, rank: Rank, row: Row):Square = square(state, Position(rank, row))



  private def piecesTheSame(piece1:Option[Piece], piece2:Option[Piece]):Boolean =
    (piece1, piece2) match {
      case (None, _) => false
      case (_, None) => false
      case (Some(p1), Some(p2)) => p1 equals p2
    }
}
