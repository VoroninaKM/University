package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label password_field;

    @FXML
    private Label login_field;

    private void setter(String login, String password){
        login_field.setText(login);
        password_field.setText(password);
    }

    @FXML
    void initialize() {
    }
}
