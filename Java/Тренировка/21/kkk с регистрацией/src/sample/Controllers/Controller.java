package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button enter_button;

    @FXML
    void initialize() {
        enter_button.setOnAction(event -> {

            try {

                Stage stages = (Stage) enter_button.getScene().getWindow();
                String log = login.getText();
                String pass = password.getText();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/windows/auth.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                stages.close();


            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });

    }
}
