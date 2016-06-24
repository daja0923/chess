package engine

import engine.Alliance.Alliance
import engine.moves.Move
import engine.squares.{Square, Coord}

/**
 * Created by jamol on 20/06/16.
 */
class Game {



  var moves:List[Move]= Nil

  var squares:List[Square] = start


  def start:List[Square] = ???

  //var turn:Alliance = Alliance.White


  def turn:Alliance = moves match {
    case Nil => Alliance.White

    case m::ms => m.piece.alliance match {
      case Alliance.White => Alliance.Black
      case Alliance.Black => Alliance.White
    }
  }



  def getMove(from:Coord, to:Coord):Option[Move] = None



  def move(from:Coord, to:Coord):Unit = {
    getMove(from, to) match {
      case Some(m) =>
        moves = m :: moves
        squares = squares.map(s => replaceIfMatch(s, m))
      case None => println("Illegal move")
    }
  }



  private def replaceIfMatch(square: Square, move: Move):Square = {
    if(square.coord equals move.dest)
      square.fill(move.piece)
    else
      square
  }
  //def currentState
}
