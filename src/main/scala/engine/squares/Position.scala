package engine.squares

import engine.Alliance
import engine.Alliance.Alliance
import engine.pieces._
import engine.squares.Rank.Rank
import engine.squares.Row.Row

/**
 * Created by jamol on 20/06/16.
 */



case class Position(rank: Rank, row: Row){
  override def toString = "{" + rank + " " + row.id + "}"
}



case class Square(position: Position, piece: Option[Piece] = None){
  def isVacant:Boolean = piece.isEmpty

  override def toString = piece.map(_.toString + " in ").getOrElse("") + position
}


object Square{
  def initiate:List[Square] = (for {
    col <- Rank.values
    row <- Row.values
  }yield buildSquare(col, row)).toList



  private def buildSquare(col:Rank, row:Row):Square = {
    val pos = Position(col, row)
    val white = Alliance.White
    val black = Alliance.Black
    row match {
      case Row.ONE => squareWithPiece(pos, white, col)
      case Row.EIGHT => squareWithPiece(pos, black, col)
      case Row.TWO => Square(pos, Some(Pawn(white)))
      case Row.SEVEN => Square(pos, Some(Pawn(black)))
      case _ => Square(Position(col, row), None)
    }
  }


  private def squareWithPiece(pos:Position, alliance: Alliance, col:Rank):Square ={
    val piece = col match {
      case Rank.A | Rank.H => Rook(alliance)
      case Rank.B | Rank.G => Knight(alliance)
      case Rank.C | Rank.F => Bishop(alliance)
      case Rank.D => Queen(alliance)
      case Rank.E => King(alliance)
    }
    Square(pos, Some(piece))
  }

}