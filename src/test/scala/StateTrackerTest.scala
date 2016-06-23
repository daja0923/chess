import engine.{Alliance, StateTracker}
import engine.moves._
import engine.pieces._
import engine.squares.{Row, Rank, Position, Square}
import org.scalatest.FunSuite
/**
 * Created by jamol on 22/06/16.
 */


/**
 *This test tests StateTracker object functions
 * with a real game with Kasparov and a group of people played over the internet in 1999
 * The game is described here: https://en.wikipedia.org/wiki/Kasparov_versus_the_World
 */
class StateTrackerTest extends FunSuite{


  val tracker = StateTracker

  var currentState:List[Square] = Square.initiate

  val expectedEndState:List[Square] = expectedState

  val white = Alliance.White
  val black = Alliance.Black


  import engine.squares.Rank._
  import engine.squares.Row._


  test("After 62nd move of white the end state must be as ecpected"){
    move(Position(E, TWO), Position(E, FOUR))
    move(Position(C, SEVEN), Position(C, FIVE))

    move(Position(G, ONE), Position(F, THREE))
    move(Position(D, SEVEN), Position(D, SIX))

    move(Position(F, ONE), Position(B, FIVE))







    assert(currentState equals expectedEndState)
  }



  def move[T <: Move](from:Position, to:Position, moveType:String = "simple", attacked:Option[Position] = None):Unit = {
    val square = tracker.square(currentState, from)
    val attackedPiece:Option[Piece] = attacked.flatMap(p =>tracker.square(currentState, p).piece)
    val move = moveType match {
      case "simple" => SimpleMove(square.piece.get,to, attackedPiece)
      case "check" => Check(square.piece.get, to, attackedPiece)
      case "en passant" => EnPassant(square.piece.get, to, attackedPiece.get)
      case "promotion" => Promotion(square.piece.get, to, attackedPiece)
    }
    currentState = tracker.changeState(currentState, move)
  }


  def castle(king:King, rook:Rook):Unit = {
    val move1 = KingCastle(king, rook)
    val move2 = RookCastle(rook, king)
    currentState = tracker.changeState(currentState, move1)
    currentState = tracker.changeState(currentState, move2)
  }

  def expectedState:List[Square] = {
    val emptySquares = for{
      rank <- Rank.values
      row <- Row.values
    }yield Square(Position(rank, row))

    emptySquares.map{square =>
      square.position match {
        case Position(C, ONE) =>    square.copy(piece = Some(King(black, square.position)))
        case Position(D, FOUR) =>   square.copy(piece = Some(Pawn(black, square.position)))
        case Position(E, FOUR) =>   square.copy(piece = Some(Queen(black, square.position)))
        case Position(F, TWO) =>    square.copy(piece = Some(Queen(white, square.position)))
        case Position(F, SIX) =>    square.copy(piece = Some(King(white, square.position)))
        case Position(G, SEVEN) =>  square.copy(piece = Some(Pawn(white, square.position)))
        case _ =>                   square
      }
    }.toList
  }
}
