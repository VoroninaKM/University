package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
    private ImageView mk_image;

    @FXML
    private ImageView tide_image;

    @FXML
    private ImageView sniper_image;

    @FXML
    private ImageView bs_image;

    @FXML
    private RadioButton mk_rad;

    @FXML
    private RadioButton bs_rad;

    @FXML
    private RadioButton tide_rad;

    @FXML
    private RadioButton sniper_rad;

    @FXML
    private Label choosed_avatar_label;

    private ToggleGroup radButtonsGroup;

    @FXML
    void initialize() {

        ToggleGroup radButtonsGroup = new ToggleGroup();
        this.mk_rad.setToggleGroup(radButtonsGroup);
        this.bs_rad.setToggleGroup(radButtonsGroup);
        this.tide_rad.setToggleGroup(radButtonsGroup);
        this.sniper_rad.setToggleGroup(radButtonsGroup);

        enter_button.setOnAction(event -> {
            try {
                if (radButtonsGroup.getSelectedToggle().equals(this.mk_rad))
                    choosed_avatar_label.setText("MonkeyKing");
                else if (radButtonsGroup.getSelectedToggle().equals(this.bs_rad))
                    choosed_avatar_label.setText("BloodSeeker");
                else if (radButtonsGroup.getSelectedToggle().equals(this.tide_rad))
                    choosed_avatar_label.setText("TideHunter");
                else if (radButtonsGroup.getSelectedToggle().equals(this.sniper_rad))
                    choosed_avatar_label.setText("Sniper");
                else choosed_avatar_label.setText("MonkeyKing");
            }
            catch (NullPointerException e){
                choosed_avatar_label.setText("MonkeyKing");
            }

            try {



                Stage stages = (Stage) enter_button.getScene().getWindow();
                String log = login.getText();
                String pass = password.getText();

                BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));
                out.write(log + "#" + pass + "#" + choosed_avatar_label.getText());
                out.newLine();
                out.close();

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
