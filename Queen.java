/**
 * Represents a chess piece that is a queen.
 *
 * @author amarino6
 * @version 1.0
 */

public class Queen extends Piece {

    /**
     * Creates a queen with its required paramaters.
     *
     * @param color the queen's color
     */
    public Queen(Color color) {
        super(color);
    }

    /**
     * Creates a default queen that is white.
     */
    public Queen() {
        super(Color.WHITE);
    }

    /**
     * Returns the queen's algebraic name.
     *
     * @return String representation of the queen's algebraic name
     */
    public String algebraicName() {
        return "Q";
    }

    /**
     * Returns the queen's Forsyth Edwards Notation name.
     *
     * @return String representation of the queen's FEN name
     */
    public String fenName() {
        if (color == Color.WHITE) {
            return "Q";
        } else {
            return "q";
        }
    }

    /**
     * Returns the queen's possible move locations based on a starting Square.
     *
     * @param square the Square on a chess board from which to move
     * @return array of Squares that the queen can move to
     */
    public Square[] movesFrom(Square square) {
        char file = square.getFile();
        char rank = square.getRank();
        int numFile = file - 96;
        int numRank = rank - 48;
        int numOfMoves = 0;

        Square[] maxDiagonalMoves = new Square[13];

        //add all valid squares in the top-left diagonal
        int tempFile = numFile;
        int tempRank = numRank;
        while (tempFile > 1 && tempRank < 8) {
            tempFile--;
            tempRank++;
            maxDiagonalMoves[numOfMoves] = new Square((char) (tempFile + 96),
                (char) (tempRank + 48));
            numOfMoves++;
        }

        //adds all valid squares in the bottom-left diagonal
        tempFile = numFile;
        tempRank = numRank;
        while (tempFile > 1 && tempRank > 1) {
            tempFile--;
            tempRank--;
            maxDiagonalMoves[numOfMoves] = new Square((char) (tempFile + 96),
                (char) (tempRank + 48));
            numOfMoves++;
        }

        //adds all valid squares in the top-right diagonal
        tempFile = numFile;
        tempRank = numRank;
        while (tempFile < 8 && tempRank < 8) {
            tempFile++;
            tempRank++;
            maxDiagonalMoves[numOfMoves] = new Square((char) (tempFile + 96),
                (char) (tempRank + 48));
            numOfMoves++;
        }

        //adds all valid squares in the bottom-right diagonal
        tempFile = numFile;
        tempRank = numRank;
        while (tempFile < 8 && tempRank > 1) {
            tempFile++;
            tempRank--;
            maxDiagonalMoves[numOfMoves] = new Square((char) (tempFile + 96),
                (char) (tempRank + 48));
            numOfMoves++;
        }

        /* creates a return array based on the total number of moves, then
        adds all the possible moves to it */
        Square[] moves = new Square[numOfMoves + 14];

        int i = 0;
        for (Square s : maxDiagonalMoves) {
            if (s != null) {
                moves[i] = s;
                i++;
            }
        }

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