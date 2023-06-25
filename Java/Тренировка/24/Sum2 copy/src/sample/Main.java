package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <h1>Узнать номер недели</h1>
 * Это приложение по введённой дате
 * выводит номер недели на экран.
 * <p>
 * @author  ФИО
 * @version 0.1
 * @since   31.05.2021
 * extends {@link Application}
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
