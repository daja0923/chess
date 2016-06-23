package engine.moves

import engine.pieces.{Piece, Rook, King}
import engine.squares.{Rank, Position}

/**
 * Created by jamol on 23/06/16.
 */
case class KingCastle(king: King, rook: Rook) extends Move{

  override def piece: Piece = king

  override def attacked: Option[Piece] = None

  override def dest: Position = rook.position.rank match {
    case Rank.A => Position(Rank.C, king.position.row)
    case Rank.H => Position(Rank.G, king.position.row)
  }
}


case class RookCastle(rook: Rook, king: King) extends Move{
  override def piece: Piece = rook

  override def attacked: Option[Piece] = None

  override def dest: Position = rook.position.rank match {
    case Rank.A => Position(Rank.D, king.position.row)
    case Rank.H => Position(Rank.F, king.position.row)
  }
}