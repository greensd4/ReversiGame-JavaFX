package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * MenuController class.
 */
public class MenuController  {
    @FXML
    private Button start;
    @FXML
    private Button exit;
    @FXML
    private Button settings;

    @FXML
    void startGame() {
        Stage stage = (Stage) start.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        try {
            HBox root = (HBox) loader.load();
            loader.setController(new GameController());
            Scene gameScene = new Scene(root, 600, 400);
            gameScene.getStylesheets().add(getClass().getResource("GameStyle.css").toExternalForm());
            stage.setScene(gameScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void getSettings() {
        Stage stage = (Stage) settings.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        try {
            GridPane root = (GridPane) loader.load();
            loader.setController(new SettingsController());
            Scene settingsScene = new Scene(root, 600, 400);
            settingsScene.getStylesheets().add(getClass().getResource("settingsStyle.css").toExternalForm());
            stage.setScene(settingsScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exitGame() {
        Stage s = (Stage) this.exit.getScene().getWindow();
        s.close();
    }
}
