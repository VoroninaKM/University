package sample;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //private JFXPanel panel = new JFXPanel();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Задание 9");
        primaryStage.setScene(new Scene(root, 452, 483));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
