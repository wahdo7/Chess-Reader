/**
 * Represents a chess piece that is a bishop.
 *
 * @author amarino6
 * @version 1.0
 */

public class Bishop extends Piece {

    /**
     * Creates a bishop with its required paramaters.
     *
     * @param color the bishop's color
     */
    public Bishop(Color color) {
        super(color);
    }

    /**
     * Creates a default bishop that is white.
     */
    public Bishop() {
        super(Color.WHITE);
    }

    /**
     * Returns the bishop's algebraic name.
     *
     * @return String representation of the bishop's algebraic name
     */
    public String algebraicName() {
        return "B";
    }

    /**
     * Returns the bishop's Forsyth Edwards Notation name.
     *
     * @return String representation of the bishop's FEN name
     */
    public String fenName() {
        if (color == Color.WHITE) {
            return "B";
        } else {
            return "b";
        }
    }

    /**
     * Returns the bishop's possible move locations based on a starting Square.
     *
     * @param square the Square on a chess board from which to move
     * @return array of Squares that the bishop can move to
     */
    public Square[] movesFrom(Square square) {
        char file = square.getFile();
        char rank = square.getRank();
        int numFile = file - 96;
        int numRank = rank - 48;
        int numOfMoves = 0;

        Square[] maxMoves = new Square[13];

        //add all valid squares in the top-left diagonal
        int tempFile = numFile;
        int tempRank = numRank;
        while (tempFile > 1 && tempRank < 8) {
            tempFile--;
            tempRank++;
            maxMoves[numOfMoves] = new Square((char) (tempFile + 96),
                (char) (tempRank + 48));
            numOfMoves++;
        }

        //adds all valid squares in the bottom-left diagonal
        tempFile = numFile;
        tempRank = numRank;
        while (tempFile > 1 && tempRank > 1) {
            tempFile--;
            tempRank--;
            maxMoves[numOfMoves] = new Square((char) (tempFile + 96),
                (char) (tempRank + 48));
            numOfMoves++;
        }

        //adds all valid squares in the top-right diagonal
        tempFile = numFile;
        tempRank = numRank;
        while (tempFile < 8 && tempRank < 8) {
            tempFile++;
            tempRank++;
            maxMoves[numOfMoves] = new Square((char) (tempFile + 96),
                (char) (tempRank + 48));
            numOfMoves++;
        }

        //adds all valid squares in the bottom-right diagonal
        tempFile = numFile;
        tempRank = numRank;
        while (tempFile < 8 && tempRank > 1) {
            tempFile++;
            tempRank--;
            maxMoves[numOfMoves] = new Square((char) (tempFile + 96),
                (char) (tempRank + 48));
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