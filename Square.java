/**
 * Represents a square on a chess board, described by its file and rank.
 *
 * @author amarino6
 * @version 1.0
 */

public class Square {
    private char rank, file;
    private String squareName;

    /**
     * Creates a square with its required paramaters.
     *
     * @param file the vetical column of the square represented as a character
     *              'a' through 'h'
     * @param rank the horizontal row of the square represented as a character
     *              '1' through '8'
     */
    public Square(char file, char rank) {
        this(Character.toString(file) + Character.toString(rank));
    }

    /**
     * Creates a square with its required paramaters.
     *
     * @param squareName String represenation of the square's file and rank
     */
    public Square(String squareName) {
        System.out.println(squareName);
        // check if the squareName is the correct length
        if (squareName != null  || squareName.length() != 2) {
            // check if the square's file is a valid character
            if (((int) squareName.charAt(0) >= 65
                    && (int) squareName.charAt(0) <= 72)
                    || ((int) squareName.charAt(0) >= 97
                    && (int) squareName.charAt(0) <= 104)) {
                // check if the square's rank is a valid character
                if ((int) squareName.charAt(1) >= 48
                    && squareName.charAt(1) <= 56) {
                    /* if the squareName contains a capital character A through
                    H, convert
                    it to its equivalent lowercase character a through h.*/
                    if ((int) squareName.charAt(0) >= 65
                        && (int) squareName.charAt(0) <= 72) {
                        this.squareName =
                            ((int) squareName.charAt(0) + 32)
                            + Character.toString(squareName.charAt(1));
                    } else {
                        this.squareName = squareName;
                    }
                    file = this.squareName.charAt(0);
                    rank = this.squareName.charAt(1);
                } else {
                    throw new InvalidSquareException(squareName);
                }
            } else {
                throw new InvalidSquareException(squareName);
            }
        } else {
            throw new InvalidSquareException(squareName);
        }
    }

    /**
     * Creates a default Square with file 'a' and rank '1'
     */
    public Square() {
        squareName = "a1";
        file = 'a';
        rank = '1';
    }

    /**
     * Returns the square's file and rank
     *
     * @return String representation of Square's file and rank
     */
    public String toString() {
        return squareName;
    }

    /**
     * Determines if square is the same as another object
     *
     * @param other an Object with which to compare the Square
     * @return boolean indicating if the square and "other" are the same
     */
    public boolean equals(Object other) {
        if (this == null) {
            return false;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof Square)) {
            return false;
        }
        Square otherSq = (Square) other;
        return (this.file == otherSq.getFile()
            && this.rank == otherSq.getRank());
    }

    /**
     * Returns a hashcode for the Square
     *
     * @return int representing the Square's hashcode
     */
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int) rank;
        result = 31 * result + (int) file;
        return result;
    }

    /**
     * Returns the square's horizontal row
     *
     * @return character representation of Square's rank
     */
    public char getRank() {
        return rank;
    }

    /**
     * Returns the square's vertical column
     *
     * @return character representation of Square's file
     */
    public char getFile() {
        return file;
    }
}