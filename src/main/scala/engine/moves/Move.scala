package engine.moves

import engine.Alliance.Alliance
import engine.pieces.Piece
import engine.squares.Position

/**
 * Created by jamol on 20/06/16.
 */
trait Move {

  def time:Long = System.currentTimeMillis()

  def piece:Piece

  def source:Position

  def dest:Position

  def alliance:Alliance = piece.alliance

  def attacked:Option[Piece]

}
