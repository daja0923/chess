package engine.squares

import engine.Alliance
import engine.Alliance.Alliance
import engine.pieces._
import engine.squares.Rank.Rank
import engine.squares.Row.Row

/**
 * Created by jamol on 20/06/16.
 */






case class Square private(coord: Coord, piece: Option[Piece] = None){

  def isVacant:Boolean = piece.isEmpty

  def clear:Square = Square(coord)

  def fill(piece: Piece):Square = Square(coord, piece)

  override def toString = piece.map(_.toString + " in ").getOrElse("") + coord
}


object Square{

  def apply(coord: Coord):Square = new Square(coord)

  def apply(coord: Coord, piece: Piece):Square = new Square(coord, Some(piece))

  def initiate:List[Square] = (for {
    col <- Rank.values
    row <- Row.values
  }yield buildSquare(col, row)).toList



  private def buildSquare(col:Rank, row:Row):Square = {
    val coord = Coord(col, row)
    val white = Alliance.White
    val black = Alliance.Black
    val piece:Option[Piece] = row match {
      case Row.ONE => Some(elitePiece(coord.rank, white))
      case Row.EIGHT => Some(elitePiece(coord.rank, black))
      case Row.TWO => Some(Pawn(white))
      case Row.SEVEN => Some(Pawn(black))
      case _ => None
    }

    Square(coord, piece)
  }


  private def elitePiece(rank:Rank, alliance: Alliance):Piece ={
    rank match {
      case Rank.A | Rank.H => Rook(alliance)
      case Rank.B | Rank.G => Knight(alliance)
      case Rank.C | Rank.F => Bishop(alliance)
      case Rank.D => Queen(alliance)
      case Rank.E => King(alliance)
    }
  }

}