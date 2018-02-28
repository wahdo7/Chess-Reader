import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;
import java.util.Optional;

/**
 * Represents a game of chess made up of individual moves.
 *
 * @author amarino6
 * @version 1.0
 */

public class ChessGame {
    static class PiecePredicate implements Predicate<Move> {

        private Piece targetPiece;

        /**
         * Creates a PiecePredicate based on the given Piece.
         *
         * @param p Piece on which to create the Predicate
         */
        public PiecePredicate(Piece p) {
            super();
            this.targetPiece = p;
        }

        /**
         * Determines whether a test object complies with the PiecePredicate
         *
         * @return boolean representation of whether the test object fulfilled
         *          the PiecePredicate
         */
        public boolean test(Move t) {
            return (t.getWhitePly().getPiece().fenName()
                == targetPiece.fenName() || t.getBlackPly().getPiece().fenName()
                == targetPiece.fenName());
        }
    }

    private List<Move> moves = new ArrayList<>();
    private String event, site, date, white, black, result;

    /**
     * Creates a ChessGame object from a list of chess Moves. Initializes all
     * of the game's metadata to null.
     *
     * @param dmoves a list of moves to be added to the ChessGame
     */
    public ChessGame(List<Move> dmoves) {
        for (Move m : dmoves) {
            moves.add(m);
        }
        this.event = null;
        this.site = null;
        this.date = null;
        this.white = null;
        this.black = null;
        this.result = null;
    }

    /**
     * Creates a ChessGame object from a list of chess Moves, as well as all of
     * the game's metadata.
     *
     * @param dmoves a list of moves to be added to the ChessGame
     * @param event a String containing the event of the ChessGame
     * @param site a String containing the site of the ChessGame
     * @param date a String containing the date of the ChessGame
     * @param white a String containing the name of the player playing white
     *          in the ChessGame
     * @param black a String containing the name of the player playing black
     *          in the ChessGame
     * @param result a String containing the result of the ChessGame
     */
    public ChessGame(List<Move> dmoves, String event, String site,
        String date, String white, String black, String result) {
        for (Move m : dmoves) {
            moves.add(m);
        }
        this.event = event;
        this.site = site;
        this.date = date;
        this.white = white;
        this.black = black;
        this.result = result;
    }

    /**
     * Returns the Move of a certain index in the ChessGame's Move List.
     *
     * @param n int representing the index of the Move List to search
     * @return Move representation of the Move at a particular index
     */
    public Move getMove(int n) {
        return moves.get(n);
    }

    /**
     * Returns a modified ArrayList of the original Move List based on a
     *  given Predicate (while leaving the original List unchanged).
     *
     * @param filter Predicate to be used to filter the Move List
     * @return ArrayList representation of the modified Move List
     */
    public ArrayList<Move> filter(Predicate<Move> filter) {
        List<Move> returnMoves = new ArrayList<>();
        for (Move m : moves) {
            if (filter.test(m)) {
                returnMoves.add(m);
            }
        }
        return (ArrayList<Move>) returnMoves;
    }

    /**
     * Returns an ArrayList containing all Moves of the original Move List
     * that contained a comment.
     *
     * @return ArrayList representation of the commented Moves from the Move
     *          List
     */
    public ArrayList<Move> getMovesWithComment() {
        Optional<String> blank = Optional.empty();
        return filter(p -> p.getWhitePly().getComment() != blank
            || p.getBlackPly().getComment() != blank);
    }

    /**
     * Returns an ArrayList containing all Moves of the original Move List
     * that did not contain a comment.
     *
     * @return ArrayList representation of the uncommented Moves from the Move
     *          List
     */
    public ArrayList<Move> getMovesWithoutComment() {
        return filter(new Predicate<Move>() {
            public boolean test(Move t) {
                Optional<String> blank = Optional.empty();
                return (t.getWhitePly().getComment() == blank
                    && t.getBlackPly().getComment() == blank);
            }
        });
    }

    /**
     * Returns an ArrayList containing all Moves of the original Move List
     * that contained a particular Piece.
     *
     * @param p Piece to be searched for in the Move List
     * @return ArrayList representation of the Moves from the Move List that
     *          contained the specified Piece
     */
    public ArrayList<Move> getMovesWithPiece(Piece p) {
        return filter(new PiecePredicate(p));
    }

    /**
     * Returns an ArrayList containing all Moves in the original List of Moves.
     *
     * @return ArrayList representation of the Moves from the Move List
     */
    public ArrayList<Move> getMoves() {
        return (ArrayList<Move>) moves;
    }

    /**
     * Returns a String representing the event of the ChessGame.
     *
     * @return String representation of the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * Returns a String representing the site of the ChessGame.
     *
     * @return String representation of the site
     */
    public String getSite() {
        return site;
    }

    /**
     * Returns a String representing the date of the ChessGame.
     *
     * @return String representation of the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns a String representing the player playing white
     * in the ChessGame.
     *
     * @return String representation of the player playing white
     */
    public String getWhite() {
        return white;
    }

    /**
     * Returns a String representing the player playing black
     * in the ChessGame.
     *
     * @return String representation of the player playing black
     */
    public String getBlack() {
        return black;
    }

    /**
     * Returns a String representing the result of the ChessGame.
     *
     * @return String representation of the result
     */
    public String getResult() {
        return result;
    }
}