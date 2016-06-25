package engine.squares


import engine.squares.Rank.Rank
import engine.squares.Row.Row


/**
 * Created by jamol on 24/06/16.
 */

case class Position(rank: Rank, row: Row){

  def diagonalUp: List[Position] = {

    @scala.annotation.tailrec
    def getDownLeftAcc(acc:List[Position]):List[Position] ={
      val start = if(acc.isEmpty) this else acc.head
      start.downLeft match {
        case None => acc
        case Some(pos) => getDownLeftAcc(pos::acc)
      }
    }

    @scala.annotation.tailrec
    def getUpRight(acc:List[Position]):List[Position] = {
      val start = if(acc.isEmpty) this else acc.head
      start.upRight match {
        case None => acc
        case Some(pos) => getUpRight(pos::acc)
      }
    }


    val before:List[Position] = getDownLeftAcc(Nil)
    val after = getUpRight(Nil)
      before ::: this :: after.reverse
  }


  def vertLine: List[Position] =
    (for(r <- Row.values) yield Position.get(this.rank, r)).toList



  def horizLine: List[Position] =
    (for(r <- Rank.values) yield Position.get(r, this.row)).toList



  def leftFrom(other: Position):Boolean = rank.id < other.rank.id


  def distance(other: Position):(Int,Int) =
    (math.abs(rank.id - other.rank.id), math.abs(row.id - other.row.id))



  def diff(other: Position):(Int, Int) = (rank.id - other.rank.id, row.id - other.row.id)


  override def toString = "{" + rank + " " + row.id + "}"


  def touches:List[Position] = List(
      up, down, left, right, upLeft, upRight,
      downLeft, downRight).flatten


  def up:Option[Position] = Row.upperTo(row).map(Position(rank, _))



  def down:Option[Position] = Row.lowerTo(row).map(Position(rank, _))



  def left:Option[Position] = Rank.leftTo(rank).map(Position(_, row))



  def right:Option[Position] = Rank.rightTo(rank).map(Position(_, row))



  def upLeft:Option[Position] = up.flatMap(_.left)



  def upRight:Option[Position] = up.flatMap(_.right)



  def downLeft:Option[Position] = down.flatMap(_.left)



  def downRight:Option[Position] = down.flatMap(_.right)

}


object Position{

  def get(rank: Rank, row: Row):Position = all.find( p =>
    p.rank.equals(rank) && p.row.equals(row)
  ).get


  val all:Set[Position] =
    for(rank <- Rank.values; row <- Row.values)
      yield apply(rank, row)

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


  def leftTo(rank: Rank):Option[Rank] = rank match {
    case A => None
    case _ => Some(Rank(rank.id - 1))
  }



  def rightTo(rank:Rank):Option[Rank] = rank match {
    case H => None
    case _ => Some(Rank(rank.id + 1))
  }
}



object Row extends Enumeration{

  type Row = Value


  
  val _1 = Value(1, "ONE")

  val TWO = Value(2, "TWO")

  val THREE = Value(3, "THREE")

  val FOUR = Value(4, "FOUR")

  val FIVE = Value(5, "FIVE")

  val SIX = Value(6, "SIX")

  val SEVEN = Value(7, "SEVEN")

  val EIGHT = Value(8, "EIGHT")
  
  def upperTo(row: Row):Option[Row] = row match {
    case EIGHT => None
    case _ => Some(Row(row.id + 1))
  }


  def lowerTo(row:Row):Option[Row] = row match {
    case `_1` => None
    case _ => Some(Row(row.id - 1))
  }
}
