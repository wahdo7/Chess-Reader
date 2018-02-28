public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    public String algebraicName() {
        return "N";
    }

    public String fenName() {
        if (color == Color.WHITE) {
            return "N";
        } else {
            return "n";
        }
    }

    public Square[] movesFrom(Square square) {
        char file = square.getFile();
        char rank = square.getRank();
        int numFile = file - 96;
        int numRank = rank - 48;
        int numOfMoves = 0;

        Square[] maxMoves = new Square[8];

        //adds the knight's valid squares, starting from the topmost square
        //on the left and moving clockwise
        if (numRank < 7) {
            if (file != 'a') {
                maxMoves[numOfMoves] = new Square((char) (numFile - 1 + 96),
                    (char) (numRank + 2 + 48));
                numOfMoves++;
            }

            if (file != 'h') {
                maxMoves[numOfMoves] = new Square((char) (numFile + 1 + 96),
                    (char) (numRank + 2 + 48));
                numOfMoves++;
            }
        }

        if (numFile < 7) {
            if (rank != '8') {
                maxMoves[numOfMoves] = new Square((char) (numFile + 2 + 96),
                    (char) (numRank + 1 + 48));
                numOfMoves++;
            }

            if (rank != '1') {
                maxMoves[numOfMoves] = new Square((char) (numFile + 2 + 96),
                    (char) (numRank - 1 + 48));
                numOfMoves++;
            }
        }

        if (numRank > 2) {
            if (file != 'a') {
                maxMoves[numOfMoves] = new Square((char) (numFile - 1 + 96),
                    (char) (numRank - 2 + 48));
                numOfMoves++;
            }

            if (file != 'h') {
                maxMoves[numOfMoves] = new Square((char) (numFile + 1 + 96),
                    (char) (numRank - 2 + 48));
                numOfMoves++;
            }
        }

        if (numFile > 2) {
            if (rank != '8') {
                maxMoves[numOfMoves] = new Square((char) (numFile - 2 + 96),
                    (char) (numRank + 1 + 48));
                numOfMoves++;
            }

            if (rank != '1') {
                maxMoves[numOfMoves] = new Square((char) (numFile - 2 + 96),
                    (char) (numRank - 1 + 48));
                numOfMoves++;
            }
        }

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