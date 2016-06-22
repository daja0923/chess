import engine.Alliance
import engine.pieces._
import engine.squares.{Position, Rank, Row, Square}
import org.scalatest.FunSuite

/**
 * Created by jamol on 21/06/16.
 */
class SquareTest extends FunSuite{


  val initialState = Square.initiate

  val white = Alliance.White
  val black = Alliance.Black


  test("Initial state must have 32 pieces, 16 for each"){
    val pieces = initialState.filter(_.piece.isDefined)
    assert(pieces.length == 32)

    val whitePieces = pieces.filter(_.piece.exists(_.alliance equals white))

    assert(whitePieces.length == 16)
  }


  test("All squares between 3 and 6 included should not have any piece"){
    val openSquares = initialState.filter{square =>
      val rowId = square.position.row.id
      rowId > 2 && rowId < 7
    }

    assert(openSquares.length == (64 - 4 * 8))

    val allOpen = openSquares.forall(_.piece.isEmpty)

    assert(allOpen)
  }


  test("All squares in rows 1 and 2 should have white pieces"){
    val squares = initialState.filter(_.position.row.id <= 2)
    val allwhitePieces = squares.forall{square =>
      square.piece.map(_.alliance) match {
        case Some(`white`) => true
        case _ => false
      }
    }
    assert(allwhitePieces)
  }


  test("All squares in rows 7 and 8 should have black pieces"){
    val squares = initialState.filter(_.position.row.id >= 7)

    val allBlackPieces = squares.forall{square =>
      square.piece.map(_.alliance) match {
        case Some(`black`) => true
        case _ => false
      }
    }
    assert(allBlackPieces)
  }


  test("All pieces in Row 2 must be white pawns"){
    val piecesInRow2 = initialState.filter(_.position.row equals Row.TWO)
    piecesInRow2.forall {
      case Square(_, Some(Pawn(`white`, _))) => true
      case _ => false
    }
  }


  test("All pieces in row 7 must be black pawns"){
    val piecesInRow2 = initialState.filter(_.position.row equals Row.SEVEN)
    piecesInRow2.forall {
      case Square(_, Some(Pawn(`black`, _))) => true
      case _ => false
    }
  }


  test("In row 1 and 8 rank e  kings must reside"){
    val squareOption = initialState.find(_.position equals Position(Rank.E, Row.ONE))
    val whitePieceOption = squareOption.flatMap(_.piece)

    val isWhiteKing = whitePieceOption match {
      case Some(King(`white`, _)) => true
      case _ => false
    }
    assert(isWhiteKing)

    val squareOption2 = initialState.find(_.position equals Position(Rank.E, Row.EIGHT))
    val blackPieceOption = squareOption2.flatMap(_.piece)

    val isBlackKing = blackPieceOption match{
      case Some(King(`black`, _)) => true
      case _ => false
    }
    assert(isBlackKing)
  }


  test("In row 8 and 1  rank d Queens must reside"){
    val squareOption = initialState.find(_.position equals Position(Rank.D, Row.ONE))
    val whitePieceOption = squareOption.flatMap(_.piece)

    val isWhiteQueen = whitePieceOption match {
      case Some(Queen(`white`, _)) => true
      case _ => false
    }
    assert(isWhiteQueen)

    val squareOption2 = initialState.find(_.position equals Position(Rank.D, Row.EIGHT))
    val blackPieceOption = squareOption2.flatMap(_.piece)

    val isBlackQueen = blackPieceOption match {
      case Some(Queen(`black`, _)) => true
      case _ => false
    }
    assert(isBlackQueen)

  }


  test("In rows 1 and 8 ranks a and h Rooks must reside"){
    val whiteRookSquares = initialState.filter{s =>
      val pos = s.position
      pos match {
        case Position(Rank.A | Rank.H, Row.ONE) => true
        case _ => false
      }
    }


    assert(whiteRookSquares.length == 2)
    val allWhiteRooks = whiteRookSquares.forall{square =>
      square.piece match {
        case Some(Rook(`white`,_)) => true
        case _ => false
      }
    }

    assert(allWhiteRooks)

    val blackRookSquares = initialState.filter{square =>
      square.position match {
        case Position(Rank.A | Rank.H, Row.EIGHT) => true
        case _ => false
      }
    }

    assert(blackRookSquares.length == 2)

    val allBlackRooks = blackRookSquares.forall{ square =>
      square.piece match {
        case Some(Rook(`black`, _)) => true
        case _ => false
      }
    }

    assert(allBlackRooks)
  }


  test("Squares In rows 1 and 8 ranks b and g should have knights"){
    val squares = initialState.filter{square =>
      square.position match {
        case Position(Rank.B | Rank.G, Row.ONE | Row.EIGHT) => true
        case _ => false
      }
    }

    val allKnights = squares.forall{square =>
      square.piece match {
        case Some(Knight(_,_)) => true
        case _ => false
      }
    }
    assert(allKnights)
  }



  test("Squares in rows 1 and 8 ranks c and f should have bishops"){
    val squares = initialState.filter{square =>
      square.position match {
        case Position(Rank.C | Rank.F, Row.ONE | Row.EIGHT) => true
        case _ => false
      }
    }

    val allBishops = squares.forall{square =>
      square.piece match {
        case Some(Bishop(_, _)) => true
        case _ => false
      }
    }
    assert(allBishops)
  }


}
