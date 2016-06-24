package engine.moves

import engine.Alliance
import engine.pieces.{Rook, King, Piece}
import engine.squares.Position
import engine.squares.Rank._
import engine.squares.Row._

/**
 * Created by jamol on 23/06/16.
 */
case class Castle(king: King, rook:Rook, override val dest:Position) extends Move{


  assert(king.alliance equals rook.alliance)

  override def piece: Piece = king

  override def attacked: Option[Piece] = None

  override def source: Position = king.alliance match {
    case Alliance.White => Position(E, ONE)
    case Alliance.Black => Position(E, EIGHT)
  }
}
