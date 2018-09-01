package board;

import board.square.Square;

/**
 * Created by vishal on 14-Aug-18.
 */
public class Board {

    private Square[] squares;

    public Board(Square[] squares) {
        this.squares = squares;
    }

    public Square[] getSquares() {
        return squares;
    }

    public void setSquares(Square[] squares) {
        this.squares = squares;
    }
}
