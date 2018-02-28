import java.util.Optional;

/**
 * Represents a single player's action within a chess game.
 *
 * @author amarino6
 * @version 1.0
 */
public class Ply {

    private Piece piece;
    private Square fromSquare, toSquare;
    private Optional<String> comment = Optional.empty();

    /**
     * Creates a ply object containing data about the player's action.
     *
     * @param piece the chess piece the action was taken on
     * @param fromSquare the chess Square that the piece moved from
     * @param toSquare the chess Square that the piece moved to
     */
    public Ply(Piece piece, Square fromSquare, Square toSquare) {
        this.piece = piece;
        this.fromSquare = fromSquare;
        this.toSquare = toSquare;
    }

    /**
     * Creates a ply object containing data about the player's action.
     *
     * @param piece the chess piece the action was taken on
     * @param fromSquare the chess Square that the piece moved from
     * @param toSquare the chess Square that the piece moved to
     * @param comment an optional comment about the player's action
     */
    public Ply(Piece piece, Square fromSquare, Square toSquare,
        Optional<String> comment) {
        this.piece = piece;
        this.fromSquare = fromSquare;
        this.toSquare = toSquare;
        if (comment.isPresent()) {
            this.comment = comment;
        }
    }

    /**
     * Returns the piece involved in the action.
     *
     * @return Piece representation of the piece involved in the action
     */
    public Piece getPiece() {
        return this.piece;
    }

    /**
     * Returns the starting Square of the player's action.
     *
     * @return Square representation of the starting location of the action
     */
    public Square getFrom() {
        return this.fromSquare;
    }

    /**
     * Returns the ending Square of the player's action.
     *
     * @return Square representation of the ending location of the action
     */
    public Square getTo() {
        return this.toSquare;
    }

    /**
     * Returns the comment associated with the action.
     *
     * @return Optional String representation of the comment of the action
     */
    public Optional<String> getComment() {
        return this.comment;
    }
}