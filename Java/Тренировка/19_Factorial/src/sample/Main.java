/**
 * Задание 19. Экзамен по программированию на языке Java
 * @autor Firstname Lastname
 * @version 1.0
 */


package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     При запуске программы открывает окно sample.fxml
     */
    @Override
    public void  start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }

    /**
     Запуск программы
     */
    public static void main(String[] args) {

        launch(args);

    }

}
