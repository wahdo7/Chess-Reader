import java.util.ArrayList;
import java.util.List;

/**
 * An object that store multiple ChessGames.
 *
 * @author amarino6
 * @version 1.0
 */

public class ChessDb {

    private List<ChessGame> games;

    /**
     * Creates a ChessDb containing two test ChessGames.
     */
    public ChessDb() {
        games = new ArrayList<>();

        List<Move> moves1 = new ArrayList<Move>();
        moves1.add(new Move(new Ply(
            new Pawn(Color.WHITE), new Square("e2"), new Square("e4")),
            new Ply(new Pawn(Color.BLACK), new Square("e7"),
            new Square("e5"))));
        games.add(new ChessGame(moves1, "Test Game 1", "Paris", "11/11/11",
            "Walter White", "Captain Blackbeard", "1-0"));

        List<Move> moves2 = new ArrayList<Move>();
        moves2.add(new Move(new Ply(
            new Pawn(Color.WHITE), new Square("a2"), new Square("a4")),
            new Ply(new Pawn(Color.BLACK), new Square("h7"),
            new Square("h5"))));
        moves2.add(new Move(new Ply(new Knight(Color.WHITE),
            new Square("b1"), new Square("c3")),
            new Ply(new Knight(Color.BLACK),
            new Square("g8"), new Square("f6"))));
        games.add(new ChessGame(moves2, "Test Game 2", "The Upside Down",
            "Today", "Bob", "Frank", "0-1"));
    }

    /**
     * Returns a list containing all of the contained ChessGames.
     *
     * @return List of ChessGames
     */
    public List<ChessGame> getGames() {
        return games;
    }
}