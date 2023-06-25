package org.kr15.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class firstController {

    @FXML
    private TextField minInput;

    @FXML
    private Button codeInputButton;

    @FXML
    private TextField maxInput;

    public firstController() throws IOException {
    }

    @FXML
    void input(MouseEvent event) {

    }

    public static List<Integer> lst = new ArrayList<Integer>();;

    public void input() throws SQLException, ClassNotFoundException, IOException {
        Integer min = Integer.parseInt(minInput.getText());
        Integer max = Integer.parseInt(maxInput.getText());

        //List<File> lst = new ArrayList<>();
        for (int i = min; i <= max; i++)
            if (i % 2 == 0 && i > 9 && i < 100) {
                lst.add(i);
            }


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/org.kr15/second.fxml"));
        Parent root = (Parent) loader.load();
        secondController controller = loader.getController();
        controller.loadData();
        Stage window = (Stage) codeInputButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 400));

    }
}