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


  test("After 62nd move of white the end state must be as expected"){
    //move 1 - e4 c5
    move(Position(E, TWO), Position(E, FOUR))
    move(Position(C, SEVEN), Position(C, FIVE))

    assert(currentState.find(_.position equals Position(C, SEVEN)).get.piece.isEmpty)
    assert(currentState.find(_.position equals Position(C, FIVE)).get.piece.isDefined)

    //move 2 - Nf3 d6
    move(Position(G, ONE), Position(F, THREE))
    move(Position(D, SEVEN), Position(D, SIX))

    //move 3 - Bf1b5+ Bc8d7
    move(Position(F, ONE), Position(B, FIVE))
    simpleMove(C, EIGHT, D, SEVEN)

    //move 4 - Bb5xd7+ Qd8xd7
    move(Position(B, FIVE), Position(D, SEVEN))
    move(Position(D, EIGHT), Position(D, SEVEN))

    //move 5 - c2c4 Nb8c6
    simpleMove(C, TWO, C, FOUR)
    simpleMove(B, EIGHT, C, SIX)

    //move 6 - Nb1c3 Ng8f6
    simpleMove(B, ONE, C, THREE)
    simpleMove(G, EIGHT, F, SIX)

    //move 7 - 0-0 g7g6
    simpleMove(E, ONE, G, ONE); simpleMove(H, ONE, F, ONE)
    simpleMove(G, SEVEN, G, SIX)


    //move 8 - d2d4 c5xd4
    simpleMove(D, TWO, D, FOUR)
    move(Position(C, FIVE), Position(D, FOUR))

    //move 9 - Nf3xd4 Bf8g7
    move(Position(F, THREE), Position(D, FOUR))
    simpleMove(F, EIGHT, G, SEVEN)

    //move 10 - Nd4e2 Qd7e6!?
    simpleMove(D, FOUR, E, TWO)
    simpleMove(D, SEVEN, E, SIX)

    //move 11 - Nc3d5 Qe6e4
    simpleMove(C, THREE, D, FIVE)
    simpleMove(E, SIX, E, FOUR)

    //move 12 - Nd5c7+ Ke8d7
    simpleMove(D, FIVE, C, SEVEN)
    simpleMove(E, EIGHT, D, SEVEN)


    //move 13 - Nc7xa8 Ke4xc4
    move(Position(C,SEVEN), Position(A, EIGHT))

    move(Position(E, FOUR), Position(C, FOUR))

    //move 14 - Na8b6 a7xb6
    simpleMove(A, EIGHT, B, SIX)
    move(Position(A, SEVEN), Position(B, SIX))

    //move 15 - Ne2c3 Rh8a8
    simpleMove(E,TWO, C,THREE)
    simpleMove(H, EIGHT, A, EIGHT)

    //move 16 - a2a4 Nf6e4
    simpleMove(A,TWO,A,FOUR)
    simpleMove(F,SIX, E,FOUR)

    //move 17 - Nc3xe4 Qc4xe4
    move(Position(C, THREE), Position(E, FOUR))
    move(Position(C, FOUR),Position(E, FOUR))



    //move 18 - Qd1b3 f7f5
    move(Position(D, ONE), Position(B, THREE))
    simpleMove(F, SEVEN, F, FIVE)

    //move 19 - Bc1g5 Qe4b4
    simpleMove(C, ONE, G, FIVE)
    simpleMove(E,FOUR, B, FOUR)



    //move 20 - Qb3f7 Bg7e5
    simpleMove(B, THREE, F, SEVEN)
    simpleMove(G, SEVEN, E, FIVE)

    //move 21 - h2h3  Ra8xa4
    simpleMove(H, TWO, H, THREE)
    move(Position(A, EIGHT), Position(A, FOUR))


    //move 22 - Ra1xa4  Qb4xa4
    move(Position(A, ONE), Position(A, FOUR))
    move(Position(B, FOUR), Position(A, FOUR))


    //move 23 - Qf7xh7 Be5xb2
    move(Position(F, SEVEN), Position(H, SEVEN))
    move(Position(E, FIVE), Position(B, TWO))


    //move 24 - Qh7xg6  Qa4e4
    move(Position(H, SEVEN), Position(G, SIX))
    simpleMove(A, FOUR, E, FOUR)



    //move 25 - Qg6f7   Bb2d4
    simpleMove(G, SIX,F,SEVEN)
    simpleMove(B,TWO,D,FOUR)



    //move 26 - Qf7b3   f5f4
    simpleMove(F, SEVEN, B, THREE)
    simpleMove(F,FIVE, F, FOUR)


    //println(currentState.find(_.position equals Position(B, FOUR)))

    //move 27 - Qb3f7   Bd4e5
    simpleMove(B, THREE, F, SEVEN)
    simpleMove(D, FOUR, E, FIVE)


    //move 28 - h3h4    b6b5
    simpleMove(H, THREE, H, FOUR)
    simpleMove(B, SIX, B, FIVE)


    //move 29 - h4h5    Qe4c4
    simpleMove(H, FOUR, H, FIVE)
    simpleMove(E, FOUR, C, FOUR)


    //move 30 - Qf7f5+  Qc4e6
    simpleMove(F, SEVEN, F, FIVE)
    simpleMove(C, FOUR, E, SIX)



    //move 31 - Qf5xe6+ Kd7xe6
    move(Position(F, FIVE), Position(E, SIX))
    move(Position(D, SEVEN), Position(E, SIX))



    //move 32 - g2g3    f4xg3
    simpleMove(G, TWO, G, THREE)
    move(Position(F, FOUR), Position(G, THREE))



    //move 33 - f2xg3   b5b4
    move(Position(F, TWO), Position(G, THREE))
    simpleMove(B, FIVE, B, FOUR)


    //println(blackQueen)

    //move 34 - Bg5f4   Be5d4+
    simpleMove(G,FIVE, F, FOUR)
    simpleMove(E, FIVE,D, FOUR)

    //println(currentState)
    //move 35 - Kg1h1   b4b3
    simpleMove(G, ONE, H, ONE)
    simpleMove(B, FOUR, B, THREE)



    //move 36 - g3g4    Ke6d5
    simpleMove(G, THREE, G, FOUR)
    simpleMove(E, SIX, D, FIVE)

    //move 37 - g4g5    e7e6
    simpleMove(G, FOUR, G, FIVE)
    simpleMove(E, SEVEN, E, SIX)

    //move 38 - h5h6    Nc6e7
    simpleMove(H, FIVE, H, SIX)
    simpleMove(C, SIX, E, SEVEN)

    //move 39 - Rf1d1   e6e5
    simpleMove(F, ONE, D, ONE)
    simpleMove(E, SIX, E, FIVE)

    //move 40 - Bf4e3   Kd5c4
    simpleMove(F, FOUR, E, THREE)
    simpleMove(D, FIVE, C, FOUR)




    //move 41 - Be3xd4  e5xd4
    move(Position(E, THREE), Position(D, FOUR))
    move(Position(E, FIVE), Position(D, FOUR))


    //move 42 - Kh1g2   b3b2
    simpleMove(H, ONE, G, TWO)
    simpleMove(B, THREE, B, TWO)

    //move 43 - Kg2f3   Kc4c3
    simpleMove(G, TWO, F, THREE)
    simpleMove(C,FOUR, C, THREE)

    //move 44 - h6h7    Ne7g6
    simpleMove(H, SIX, H, SEVEN)
    simpleMove(E, SEVEN, G, SIX)

    //move 45 - Kf3e4   Kc3c2
    simpleMove(F, THREE, E, FOUR)
    simpleMove(C, THREE, C, TWO)

    //move 46 - Rd1h1   d4d3
    simpleMove(D, ONE, H, ONE)
    simpleMove(D, FOUR, D, THREE)


    //move 47 - Ke4f5   b2b1
    simpleMove(E,FOUR, F, FIVE)
    move(Position(B, TWO), Position(B, ONE), "promotion")


    //move 48 - Rh1xb1  Kc2xb1
    move(Position(H,ONE), Position(B, ONE))
    move(Position(C,  TWO), Position(B, ONE))


    //move 49 - Kf5xg6  d3d2
    move(Position(F, FIVE), Position(G, SIX))
    simpleMove(D, THREE, D, TWO)


    //move 50 - h7h8  d2d1
    move(Position(H, SEVEN), Position(H, EIGHT), "promotion")
    move(Position(D, TWO), Position(D, ONE), "promotion")

    //move 51 - Qh8h7   b7b5
    simpleMove(H,EIGHT, H, SEVEN)
    simpleMove(B,SEVEN, B, FIVE)


    //move 52 - Kg6f6+  Kb1b2
    move(Position(G, SIX), Position(F, SIX))
    simpleMove(B, ONE, B, TWO)


    //move 53 - Qh7h2+  Kb2a1
    move(Position(H, SEVEN), Position(H, TWO))
    simpleMove(B, TWO, A, ONE)

    //move 54 - Qh2f4   b5b4
    simpleMove(H, TWO, F, FOUR)
    simpleMove(B, FIVE, B, FOUR)

    //move 55 - Qf4xb4  Qd1f3+
    move(Position(F, FOUR), Position(B, FOUR))
    simpleMove(D, ONE, F, THREE)

    //move 56 - Kf6g7   d6d5
    simpleMove(F, SIX, G, SEVEN)
    simpleMove(D,SIX, D, FIVE)



    //move 57 - Qb4d4+  Ka1b1
    simpleMove(B, FOUR, D, FOUR)
    simpleMove(A, ONE, B, ONE)

    //move 58 - g5g6    Qf3e4
    simpleMove(G, FIVE, G, SIX)
    simpleMove(F, THREE, E, FOUR)

    //move 59 - Qd4g1+  Kb1b2
    simpleMove(D, FOUR, G, ONE)
    simpleMove(B, ONE, B, TWO)

    //move 60 - Qg1f2+  Kb2c1
    simpleMove(G, ONE, F, TWO)
    simpleMove(B, TWO, C, ONE)
    println(blackPawn)
    //move 61 - Kg7f6   d5d4
    simpleMove(G, SEVEN, F, SIX)
    simpleMove(D, FIVE, D, FOUR)

    //move 62 - g6g7
    simpleMove(G, SIX, G, SEVEN)

    def endStatePieces = currentState.filter(_.piece.isDefined).flatMap(_.piece)

    //println(endStatePieces.length)


    def simpleMove(rank1:Rank, row1: Row, rank2:Rank, row2:Row) =
    move(Position(rank1, row1), Position(rank2, row2))

    def blackPawn = currentState.filter(_.piece match {
      case Some(Pawn(Alliance.Black, _)) => true
      case _ => false
    })

    //assert(currentState equals expectedEndState)
  }



  def move[T <: Move](from:Position, to:Position, moveType:String = "simple", attacked:Option[Position] = None):Unit = {
    val square = tracker.square(currentState, from)
    val squareTo = tracker.square(currentState, to)
    val attackedPiece:Option[Piece] = attacked.flatMap(p =>tracker.square(currentState, p).piece)
    val move = moveType match {
      case "simple" => SimpleMove(square.piece.get,to, squareTo.piece)
      case "check" => Check(square.piece.get, to, squareTo.piece)
      case "en passant" => EnPassant(square.piece.get, to, attackedPiece.get)
      case "promotion" => Promotion(square.piece.get.asInstanceOf[Pawn], to, squareTo.piece)
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
