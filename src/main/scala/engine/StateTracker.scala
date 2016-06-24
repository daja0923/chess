package engine

import engine.moves.Move
import engine.pieces.Piece
import engine.squares.Rank.Rank
import engine.squares.Row.Row
import engine.squares.{Coord, Square}

/**
 * Created by jamol on 22/06/16.
 */
object StateTracker {

  type State = List[Square]

  /**
   * tracks from the given state and the moves
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


  def square(state: State, position: Coord):Square = {
    val squareOption = state.find(_.coord equals position)
    if(squareOption.isEmpty)
      throw new NoSuchElementException("square at position " + position)
    else
      squareOption.get
  }


  def square(state:State, rank: Rank, row: Row):Square = square(state, Coord(rank, row))



  def changeState(current:State, move: Move):State = current.map(updateSquare(_, move))


  private def updateSquare(square: Square, move: Move): Square = {
    if(square.coord equals move.source)
      square.clear
    else if (square.coord equals move.dest)
      square.fill(move.piece)
    else if(piecesTheSame(square.piece, move.attacked))
      square.clear //clearing attacked piece square explicitly because it is not always destination square
    else square
  }


  private def piecesTheSame(piece1:Option[Piece], piece2:Option[Piece]):Boolean =
    (piece1, piece2) match {
      case (None, _) => false
      case (_, None) => false
      case (Some(p1), Some(p2)) => p1 equals p2
    }
}
