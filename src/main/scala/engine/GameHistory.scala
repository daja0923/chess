package engine

import engine.squares.Square

/**
 * Created by jamol on 20/06/16.
 */
class GameHistory(moves:List[Move]) {

  type State = List[Square]

  val initialState:State = start


  def start:State = Square.initiate


  def endState:State = StateTracker.trackState(initialState, moves.reverse)

}
