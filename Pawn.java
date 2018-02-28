/**
 * Represents a chess piece that is a pawn.
 *
 * @author amarino6
 * @version 1.0
 */

public class Pawn extends Piece {

    /**
     * Creates a pawn with its required paramaters.
     *
     * @param color the pawn's color
     */
    public Pawn(Color color) {
        super(color);
    }

    /**
     * Creates a default pawn that is white.
     */
    public Pawn() {
        super(Color.WHITE);
    }

    /**
     * Returns the pawn's algebraic name.
     *
     * @return String representation of the pawn's algebraic name
     */
    public String algebraicName() {
        return "";
    }

    /**
     * Returns the pawn's Forsyth Edwards Notation name.
     *
     * @return String representation of the pawn's FEN name
     */
    public String fenName() {
        return "";
    }

    /**
     * Returns the pawn's possible move locations based on a starting Square.
     *
     * @param square the Square on a chess board from which to move
     * @return array of Squares that the pawn can move to
     */
    public Square[] movesFrom(Square square) {
        char file = square.getFile();
        char rank = square.getRank();
        int numOfMoves = 1;

        //determine if the pawn is on its starting row
        if (color == Color.WHITE && rank == '2') {
            numOfMoves++;
        } else if (color == Color.BLACK && rank == '7') {
            numOfMoves++;
        }

        Square[] moves = new Square[numOfMoves];

        //add all valid squares
        if (color == Color.WHITE && rank != '8') {
            moves[0] = new Square(file, (char) (rank + 1));
            if (rank == '2') {
                moves[1] = new Square(file, (char) (rank + 2));
            }
        } else if (color == Color.BLACK && rank != '1') {
            moves[0] = new Square(file, (char) (rank - 1));
            if (rank == '7') {
                moves[1] = new Square(file, (char) (rank - 2));
            }
        }

        return moves;
    }
}
