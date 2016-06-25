import engine.moves._
import engine.pieces._
import engine.squares.{Position, Square}
import engine.{Alliance, StateTracker}
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


  val white = Alliance.White
  val black = Alliance.Black


  import engine.squares.Rank._
  import engine.squares.Row._


  test("After 62nd move of white the end state must be as expected"){
    //move 1 - e4 c5
    simpleMove(E, TWO, E, FOUR)
    simpleMove(C, SEVEN, C, FIVE)

    assert(currentState.find(_.coord equals Position(C, SEVEN)).get.piece.isEmpty)
    assert(currentState.find(_.coord equals Position(C, FIVE)).get.piece.isDefined)

    //move 2 - Nf3 d6
    move(Position(G, _1), Position(F, THREE))
    move(Position(D, SEVEN), Position(D, SIX))

    //move 3 - Bf1b5+ Bc8d7
    move(Position(F, _1), Position(B, FIVE))
    simpleMove(C, EIGHT, D, SEVEN)

    //move 4 - Bb5xd7+ Qd8xd7
    move(Position(B, FIVE), Position(D, SEVEN))
    move(Position(D, EIGHT), Position(D, SEVEN))

    //move 5 - c2c4 Nb8c6
    simpleMove(C, TWO, C, FOUR)
    simpleMove(B, EIGHT, C, SIX)

    //move 6 - Nb1c3 Ng8f6
    simpleMove(B, _1, C, THREE)
    simpleMove(G, EIGHT, F, SIX)

    //move 7 - 0-0 g7g6
    val king = StateTracker.square(currentState, E, _1)
      .piece.get
      .asInstanceOf[King]
    val rook = StateTracker.square(currentState, H, _1)
    .piece.get
    .asInstanceOf[Rook]
    val kingCastle = SimpleMove(king,Position(E, _1), Position(G, _1))
    val rookCastle = SimpleMove(rook, Position(H, _1), Position(F, _1))
    castle(kingCastle, rookCastle)
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
    move(Position(D, _1), Position(B, THREE))
    simpleMove(F, SEVEN, F, FIVE)

    //move 19 - Bc1g5 Qe4b4
    simpleMove(C, _1, G, FIVE)
    simpleMove(E,FOUR, B, FOUR)



    //move 20 - Qb3f7 Bg7e5
    simpleMove(B, THREE, F, SEVEN)
    simpleMove(G, SEVEN, E, FIVE)

    //move 21 - h2h3  Ra8xa4
    simpleMove(H, TWO, H, THREE)
    move(Position(A, EIGHT), Position(A, FOUR))


    //move 22 - Ra1xa4  Qb4xa4
    move(Position(A, _1), Position(A, FOUR))
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
    simpleMove(G, _1, H, _1)
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
    simpleMove(F, _1, D, _1)
    simpleMove(E, SIX, E, FIVE)

    //move 40 - Bf4e3   Kd5c4
    simpleMove(F, FOUR, E, THREE)
    simpleMove(D, FIVE, C, FOUR)




    //move 41 - Be3xd4  e5xd4
    move(Position(E, THREE), Position(D, FOUR))
    move(Position(E, FIVE), Position(D, FOUR))


    //move 42 - Kh1g2   b3b2
    simpleMove(H, _1, G, TWO)
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
    simpleMove(D, _1, H, _1)
    simpleMove(D, FOUR, D, THREE)


    //move 47 - Ke4f5   b2b1
    simpleMove(E,FOUR, F, FIVE)
    move(Position(B, TWO), Position(B, _1), "promotion")


    //move 48 - Rh1xb1  Kc2xb1
    move(Position(H,_1), Position(B, _1))
    move(Position(C,  TWO), Position(B, _1))


    //move 49 - Kf5xg6  d3d2
    move(Position(F, FIVE), Position(G, SIX))
    simpleMove(D, THREE, D, TWO)


    //move 50 - h7h8  d2d1
    move(Position(H, SEVEN), Position(H, EIGHT), "promotion")
    move(Position(D, TWO), Position(D, _1), "promotion")

    //move 51 - Qh8h7   b7b5
    simpleMove(H,EIGHT, H, SEVEN)
    simpleMove(B,SEVEN, B, FIVE)


    //move 52 - Kg6f6+  Kb1b2
    move(Position(G, SIX), Position(F, SIX))
    simpleMove(B, _1, B, TWO)


    //move 53 - Qh7h2+  Kb2a1
    move(Position(H, SEVEN), Position(H, TWO))
    simpleMove(B, TWO, A, _1)

    //move 54 - Qh2f4   b5b4
    simpleMove(H, TWO, F, FOUR)
    simpleMove(B, FIVE, B, FOUR)

    //move 55 - Qf4xb4  Qd1f3+
    move(Position(F, FOUR), Position(B, FOUR))
    simpleMove(D, _1, F, THREE)

    //move 56 - Kf6g7   d6d5
    simpleMove(F, SIX, G, SEVEN)
    simpleMove(D,SIX, D, FIVE)



    //move 57 - Qb4d4+  Ka1b1
    simpleMove(B, FOUR, D, FOUR)
    simpleMove(A, _1, B, _1)

    //move 58 - g5g6    Qf3e4
    simpleMove(G, FIVE, G, SIX)
    simpleMove(F, THREE, E, FOUR)

    //move 59 - Qd4g1+  Kb1b2
    simpleMove(D, FOUR, G, _1)
    simpleMove(B, _1, B, TWO)

    //move 60 - Qg1f2+  Kb2c1
    simpleMove(G, _1, F, TWO)
    simpleMove(B, TWO, C, _1)
    //println(blackPawn)
    //move 61 - Kg7f6   d5d4
    simpleMove(G, SEVEN, F, SIX)
    simpleMove(D, FIVE, D, FOUR)

    //move 62 - g6g7
    simpleMove(G, SIX, G, SEVEN)


    val whiteKingSquare = StateTracker.square(currentState, F, SIX)
    assert(whiteKingSquare.piece.exists{
      case King(`white`) => true
      case _ => false
    })

    val blackKingSquare = StateTracker.square(currentState, C, _1)
    assert(!blackKingSquare.isVacant)
    assert(blackKingSquare.piece.exists {
      case King(`black`) => true
      case _ => false
    })

    val whiteQueenSquare = StateTracker.square(currentState, F, TWO)
    assert(whiteQueenSquare.piece.exists{
      case Queen(`white`) => true
      case _ => false
    })

    val blackQueenSquare = StateTracker.square(currentState, E, FOUR)
    assert(blackQueenSquare.piece.exists{
      case Queen(`black`) => true
      case _ => false
    })

    val whitePawnSquare = StateTracker.square(currentState, G, SEVEN)
    assert(whitePawnSquare.piece.exists{
      case Pawn(`white`) => true
      case _ => false
    })

    val blackPawnSquare = StateTracker.square(currentState, D, FOUR)
    assert(blackPawnSquare.piece.exists{
      case Pawn(`black`) => true
      case _ => false
    })


    assert(currentState.count(!_.isVacant) == 6)
  }











  def simpleMove(rank1:Rank, row1: Row, rank2:Rank, row2:Row) =
    move(Position(rank1, row1), Position(rank2, row2))

  def blackPawn = currentState.filter(_.piece match {
    case Some(Pawn(Alliance.Black)) => true
    case _ => false
  })


  def move[T <: Move](from:Position, to:Position,
                      moveType:String = "simple",
                      attacked:Option[Position] = None):Unit = {
    val square = tracker.square(currentState, from)
    val squareTo = tracker.square(currentState, to)
    val attackedPiece:Option[Piece] = attacked.flatMap(p =>tracker.square(currentState, p).piece)
    val move = moveType match {
      case "simple" => SimpleMove(square.piece.get, from,to)
      case "check" => Check(square.piece.get, from, to)
      case "en passant" =>
        EnPassant(square.piece.get, from, to, attackedPiece.get.asInstanceOf[Pawn])
      case "promotion" => Promotion(square.piece.get.asInstanceOf[Pawn], from, to)
    }
    currentState = tracker.changeState(currentState, move)
  }


  def castle(king:SimpleMove, rook:SimpleMove):Unit = {
    val move = Castle(king, rook)
    currentState = tracker.changeState(currentState, move)
  }

}
