/**
 * Represents a generic chess piece.
 *
 * @author amarino6
 * @version 1.0
 */

public abstract class Piece {

    protected Color color;

    /**
     * Creates a piece with its required paramaters.
     *
     * @param color the piece's color
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Creates a default piece that is white.
     */
    public Piece() {
        color = Color.WHITE;
    }

    /**
     * Returns the piece's color.
     *
     * @return the piece's color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Returns the piece's algebraic name.
     *
     * @return String representation of the piece's algebraic name
     */
    public abstract String algebraicName();

    /**
     * Returns the piece's Forsyth Edwards Notation name.
     *
     * @return String representation of the piece's FEN name
     */
    public abstract String fenName();

    /**
     * Returns the piece's possible move locations based on a starting Square.
     *
     * @param square the Square on a chess board from which to move
     * @return array of Squares that the piece can move to
     */
    public abstract Square[] movesFrom(Square square);

}