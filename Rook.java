/**
 * Represents a chess piece that is a rook.
 *
 * @author amarino6
 * @version 1.0
 */

public class Rook extends Piece {

    /**
     * Creates a rook with its required paramaters.
     *
     * @param color the rook's color
     */
    public Rook(Color color) {
        super(color);
    }

    /**
     * Creates a default rook that is white.
     */
    public Rook() {
        super(Color.WHITE);
    }

    /**
     * Returns the rook's algebraic name.
     *
     * @return String representation of the rook's algebraic name
     */
    public String algebraicName() {
        return "R";
    }

    /**
     * Returns the rook's Forsyth Edwards Notation name.
     *
     * @return String representation of the rook's FEN name
     */
    public String fenName() {
        if (color == Color.WHITE) {
            return "R";
        } else {
            return "r";
        }
    }

    /**
     * Returns the rook's possible move locations based on a starting Square.
     *
     * @param square the Square on a chess board from which to move
     * @return array of Squares that the rook can move to
     */
    public Square[] movesFrom(Square square) {
        char file = square.getFile();
        char rank = square.getRank();
        int numFile = file - 96;
        int numRank = rank - 48;
        int numOfMoves = 0;

        Square[] moves = new Square[14];

        //add all valid squares in the horizontal direction
        for (int f = 1; f < 9; f++) {
            if (f != numFile) {
                moves[numOfMoves] = new Square((char) (f + 96), rank);
                numOfMoves++;
            }
        }

        //add all valid squares in the vertical direction
        for (int r = 1; r < 9; r++) {
            if (r != numRank) {
                moves[numOfMoves] = new Square(file, (char) (r + 48));
                numOfMoves++;
            }
        }

        return moves;
    }
}