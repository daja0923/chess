package engine.squares


import engine.squares.Rank.Rank
import engine.squares.Row.Row


/**
 * Created by jamol on 24/06/16.
 */

case class Coord(rank: Rank, row: Row){
  override def toString = "{" + rank + " " + row.id + "}"
}




object Rank extends Enumeration{

  type Rank = Value


  val A = Value(1, "A")

  val B = Value(2, "B")

  val C = Value(3, "C")

  val D = Value(4, "D")

  val E = Value(5, "E")

  val F = Value(6, "F")

  val G = Value(7, "G")

  val H = Value(8, "H")
}



object Row extends Enumeration{

  type Row = Value


  val ONE = Value(1, "ONE")

  val TWO = Value(2, "TWO")

  val THREE = Value(3, "THREE")

  val FOUR = Value(4, "FOUR")

  val FIVE = Value(5, "FIVE")

  val SIX = Value(6, "SIX")

  val SEVEN = Value(7, "SEVEN")

  val EIGHT = Value(8, "EIGHT")
}
