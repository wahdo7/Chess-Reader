/**
 * Represents an action made by each player within a chess game.
 *
 * @author amarino6
 * @version 1.0
 */

public class Move {

    private Ply whitePly, blackPly;

    /**
     * Creates a ply object containing data about the player's action.
     *
     * @param whitePly the action of the player playing white
     * @param blackPly the action of the player playing black
     */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

    /**
     * Returns the ply of the white player.
     *
     * @return Ply representation of the white player's action
     */
    public Ply getWhitePly() {
        return this.whitePly;
    }

    /**
     * Returns the ply of the black player.
     *
     * @return Ply representation of the black player's action
     */
    public Ply getBlackPly() {
        return this.blackPly;
    }

    /**
     * Returns a String representation of the move as it would be found in
     * a pgn file.
     *
     * @return String representation of the move
     */
    public String toString() {
        return getWhitePly().getPiece().algebraicName()
            + getWhitePly().getTo() + " "
            + getBlackPly().getPiece().algebraicName() + getBlackPly().getTo();
    }
}