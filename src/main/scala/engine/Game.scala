package engine

import engine.Alliance.Alliance
import engine.positions.{Square, Position}

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



  def getMove(from:Position, to:Position):Option[Move] = None



  def move(from:Position, to:Position):Unit = {
    getMove(from, to) match {
      case Some(m) =>
        moves = m :: moves
        squares = squares.map(s => replaceIfMatch(s, m))
      case None => println("Illegal move")
    }
  }



  private def replaceIfMatch(square: Square, move: Move):Square = {
    if(square.position equals move.dest)
      square.copy(piece = Some(move.piece))
    else
      square
  }
  //def currentState
}
