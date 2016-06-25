package engine.squares

import org.scalatest.FunSuite
import engine.squares.Rank._
import engine.squares.Row._
/**
 * Created by jamol on 25/06/16.
 */
class PositionTest extends FunSuite{

  test("Difference of (C, 2) and (B, 5) must be (1, -3)") {
    assert((Position(C, TWO) diff Position(B, FIVE)) == (1, -3))
  }


  test("Difference of (A, 1) and (H, 8) must be (-7, -7)"){
    assert(Position(A, _1).diff(Position(H, EIGHT)) == (-7, -7))
  }



  test("Distance of (A, 1) from (H, 8) must be (7,7)"){
    assert(Position(A, _1).distance(Position(H, EIGHT)) == (7, 7))
  }



  test("Distance and Difference of (H, 7) and (D, 5) are equal"){
    val c1 = Position(H, SEVEN)
    val c2 = Position(D, FIVE)
    assert(c1.diff(c2) == c1.distance(c2))
  }



  test("(A, 3) must be left from (B, 7)"){
    val c1 = Position(A, THREE)
    val c2 = Position(B, SEVEN)

    assert(c1 leftFrom c2)
  }



  test("(C, 1) must not be left from (B, 7)"){
    val c1 = Position(C, _1)
    val c2 = Position(B, SEVEN)

    assert(!(c1 leftFrom c2))
  }




  test("(A, 1) has touches of (A, 2), (B, 1) and (B, 2)"){
    val pos = Position(A, _1)
    val touches: List[Position] = pos.touches
    assert(touches.contains(Position(A, TWO)))
    assert(touches.contains(Position(B, _1)))
    assert(touches.contains(Position(B, TWO)))
  }



  test("(A, 8) has touches of (A, 7), (B, 8) and (B,7)"){
    val pos = Position(A, EIGHT)
    val touches: List[Position] = pos.touches
    assert(touches.contains(Position(A, SEVEN)))
    assert(touches.contains(Position(B, EIGHT)))
    assert(touches.contains(Position(B, SEVEN)))
  }



  test("(H, 8) has touches of (H, 7), (G, 8) and (G,7)"){
    val pos = Position(H, EIGHT)
    val touches: List[Position] = pos.touches
    assert(touches.contains(Position(H, SEVEN)))
    assert(touches.contains(Position(G, EIGHT)))
    assert(touches.contains(Position(G, SEVEN)))
  }



  test("(H, 1) has touches of (H, 2), (G, 1) and (G,2)"){
    val pos = Position(H, _1)
    val touches: List[Position] = pos.touches
    assert(touches.contains(Position(H, TWO)))
    assert(touches.contains(Position(G, _1)))
    assert(touches.contains(Position(G, TWO)))
  }



  test("(C, 5) has touches of (B,4), (B, 5), (B,6),  (C, 4), (C,6), (D, 4), (D, 5) and (D, 6)"){
    val pos = Position.get(C, FIVE)
    val touches = pos.touches

    assert(touches.length == 8)
    assert(touches.contains(Position.get(B, FOUR)))
    assert(touches.contains(Position.get(B, FIVE)))
    assert(touches.contains(Position.get(B, SIX)))
    assert(touches.contains(Position.get(C,FOUR)))
    assert(touches.contains(Position.get(C, SIX)))
    assert(touches.contains(Position.get(D, FOUR)))
    assert(touches.contains(Position.get(D, FIVE)))
    assert(touches.contains(Position.get(D, SIX)))
  }


  test("C4 is on horizontal line of from A4 to H4"){
    val pos = Position.get(C, FOUR)

    val horizLine:List[Position] = pos.horizLine

    assert(horizLine.length == 8)
    assert(horizLine.forall(_.row equals FOUR))
  }


  test("D7 is on vertical line from D1 to C8"){
    val pos = Position.get(D, SEVEN)

    val vertLine:List[Position] = pos.vertLine
    assert(vertLine.length == 8)
    assert(vertLine.forall(_.rank equals D))
  }


  test("(A,6) is on diagonalUp of (A, 6) (B,7) and (C,8)"){
    val pos = Position.get(A, SIX)
    val diagonalUp:List[Position] = pos.diagonalUp


    assert(diagonalUp.length == 3)
    assert(diagonalUp.exists{
      case Position(A, SIX) => true
      case Position(B, SEVEN) => true
      case Position(C, EIGHT) => true
      case _ => false
    })
  }

  test("D5 is on diagonalUp of A2, B3, C4, D5, E6, F7, G8"){
    val pos = Position.get(D, FIVE)

    val diagonalUp = pos.diagonalUp
    println(diagonalUp)

    assert(diagonalUp.length == 7)
    assert(diagonalUp.exists{
      case Position(A, TWO) |
        Position(B, THREE) |
        Position(C, FOUR) |
        Position(D, FIVE) |
        Position(E, SIX) |
        Position(G, EIGHT) => true

      case _ => false
    })
  }

}
