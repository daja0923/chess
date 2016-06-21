import engine.Alliance
import engine.positions.Square
import org.scalatest.FunSuite

/**
 * Created by jamol on 21/06/16.
 */
class SquareTest extends FunSuite{


  val initialState = Square.start

  test("Initial state must have 32 pieces, 16 for each"){
    val pieces = initialState.filter(s => s.piece.isDefined)
    assert(pieces.length == 32)

    val whitePieces = pieces.filter(s => s.piece.exists(p => p.alliance equals Alliance.White))

    assert(whitePieces.length == 16)
  }


  test("All pieces in Row 2 must be white pawns"){

  }


}
