import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * An graphic application that displays the ChessGames within a ChessDb, and
 * all of the games' metadata and move data.
 *
 * @author amarino6
 * @version 1.0
 */

public class ChessGui extends Application {

    /**
     * Creates the graphic user interface containing all of the necessary
     * componenets.
     *
     * @param stage the Stage on which to create the interface
     */
    @Override public void start(Stage stage) {
        ChessDb gameDb = new ChessDb();
        ObservableList<ChessGame> games =
            FXCollections.observableArrayList(gameDb.getGames());
        TableView<ChessGame> table = createTable(games);

        Button viewButton = new Button("View Game");
        viewButton.setOnAction(e -> {
                ChessGame msg = table.getSelectionModel().getSelectedItem();
                viewDialog(msg);
            });
        viewButton.disableProperty()
            .bind(Bindings.isNull(table.getSelectionModel()
                .selectedItemProperty()));

        Button dismissButton = new Button("Dismiss");
        dismissButton.setOnAction(e -> Platform.exit());

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(viewButton, dismissButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, buttonBox);
        Scene scene = new Scene(vbox, 800, 400);
        stage.setScene(scene);
        stage.setTitle("Chess DB GUI");
        stage.show();
    }

    private
        TableView<ChessGame>
        createTable(ObservableList<ChessGame> games) {
        TableView<ChessGame> table = new TableView<ChessGame>();
        table.setItems(games);

        TableColumn<ChessGame, String> eventCol =
            new TableColumn<ChessGame, String>("Event");
        eventCol.setCellValueFactory(new PropertyValueFactory("event"));

        TableColumn<ChessGame, String> siteCol =
            new TableColumn<ChessGame, String>("Site");
        siteCol.setCellValueFactory(new PropertyValueFactory("site"));

        TableColumn<ChessGame, String> dateCol =
            new TableColumn<ChessGame, String>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));

        TableColumn<ChessGame, String> whiteCol =
            new TableColumn<ChessGame, String>("White");
        whiteCol.setCellValueFactory(new PropertyValueFactory("white"));

        TableColumn<ChessGame, String> blackCol =
            new TableColumn<ChessGame, String>("Black");
        blackCol.setCellValueFactory(new PropertyValueFactory("black"));

        TableColumn<ChessGame, String> resultCol =
            new TableColumn<ChessGame, String>("Result");
        resultCol.setCellValueFactory(new PropertyValueFactory("result"));

        table.getColumns().setAll(eventCol, siteCol, dateCol, whiteCol,
            blackCol, resultCol);
        return table;
    }

    /**
     * Creates a popup dialog box containing information about
     * a single ChessGame
     *
     * @param game the ChessGame whose data will be displayed
     */
    private void viewDialog(ChessGame game) {
        String moveString = "";
        int count = 0;
        for (Move m : game.getMoves()) {
            count++;
            moveString = moveString + " " + Integer.toString(count) + ". "
                + m.toString();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(game.getEvent());
        alert.setHeaderText(String.format("Data for selected game"));
        alert.setContentText("Event: " + game.getEvent() + "\n"
            + "Site: " + game.getSite() + "\n"
            + "Date: " + game.getDate() + "\n"
            + "White: " + game.getWhite() + "\n"
            + "Black: " + game.getBlack() + "\n"
            + "Result: " + game.getResult()  + "\n" + "\n"
            + "Moves: " + "\n" + moveString);
        alert.showAndWait();
    }
}