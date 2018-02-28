/**
 * Represents a chess piece that is a king.
 *
 * @author amarino6
 * @version 1.0
 */

public class King extends Piece {

    /**
     * Creates a king with its required paramaters.
     *
     * @param color the king's color
     */
    public King(Color color) {
        super(color);
    }

    /**
     * Creates a default king that is white.
     */
    public King() {
        super(Color.WHITE);
    }

    /**
     * Returns the king's algebraic name.
     *
     * @return String representation of the king's algebraic name
     */
    public String algebraicName() {
        return "K";
    }

    /**
     * Returns the king's Forsyth Edwards Notation name.
     *
     * @return String representation of the king's FEN name
     */
    public String fenName() {
        if (color == Color.WHITE) {
            return "K";
        } else {
            return "k";
        }
    }

    /**
     * Returns the king's possible move locations based on a starting Square.
     *
     * @param square the Square on a chess board from which to move
     * @return array of Squares that the king can move to
     */
    public Square[] movesFrom(Square square) {
        char file = square.getFile();
        char rank = square.getRank();
        int numOfMoves = 0;

        Square[] maxMoves = new Square[8];

        //adds the top-left sqaure as a possible move
        if (file != 'a' && rank != '8') {
            maxMoves[0] = new Square((char) (file - 1), (char) (rank + 1));
            numOfMoves++;
        }

        //adds the left square as a possible move
        if (file != 'a') {
            maxMoves[1] = new Square((char) (file - 1), rank);
            numOfMoves++;
        }

        //adds the bottom-left square as a possible move
        if (file != 'a' && rank != '1') {
            maxMoves[2] = new Square((char) (file - 1), (char) (rank - 1));
            numOfMoves++;
        }

        //adds the top square as a possible move
        if (rank != '8') {
            maxMoves[3] = new Square(file, (char) (rank + 1));
            numOfMoves++;
        }

        //adds the bottom square as a possible move
        if (rank != '1') {
            maxMoves[4] = new Square(file, (char) (rank - 1));
            numOfMoves++;
        }

        //adds the top-right sqaure as a possible move
        if (file != 'h' && rank != '8') {
            maxMoves[5] = new Square((char) (file + 1), (char) (rank + 1));
            numOfMoves++;
        }

        //adds the right sqaure as a possible move
        if (file != 'h') {
            maxMoves[6] = new Square((char) (file + 1), rank);
            numOfMoves++;
        }

        //adds the bottom-right sqaure as a possible move
        if (file != 'h' && rank != '1') {
            maxMoves[7] = new Square((char) (file + 1), (char) (rank - 1));
            numOfMoves++;
        }

        /* creates a return array based on the total number of moves, then
        adds all the possible moves to it */
        Square[] moves = new Square[numOfMoves];

        int i = 0;
        for (Square s : maxMoves) {
            if (s != null) {
                moves[i] = s;
                i++;
            }
        }

        return moves;
    }
}