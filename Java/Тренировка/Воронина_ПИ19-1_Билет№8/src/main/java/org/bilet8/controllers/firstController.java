package org.bilet8.controllers;

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
import java.util.Arrays;
import java.util.List;

public class firstController {

    @FXML
    private TextField inputMes;

    @FXML
    private Button codeInputButton;

    @FXML
    void inputCode(MouseEvent event) {

    }

    public static List<String> lst = new ArrayList<>();;

    public void input() throws SQLException, ClassNotFoundException, IOException {
        int count = 1;
        String text = inputMes.getText();
        String[] words = text.toLowerCase().replaceAll("[,.!:?]", "").split("\\s");
        Arrays.sort(words);
        for (int i = 1; i < words.length; i++) {
            if (words[i].equals(words[i-1])) {
                do {
                    count++;
                    i++;
                } while(i < words.length && words[i].equals(words[i - 1]));
            }
            String res = "Слово \"" + words[i - 1] + "\" встречается в тексте: " + count + " раз.";
            lst.add(res);
            count = 1;
        }


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/org/bilet8/second.fxml"));
        Parent root = (Parent) loader.load();
        secondController controller = loader.getController();
        controller.loadData();
        Stage window = (Stage) codeInputButton.getScene().getWindow();
        window.setScene(new Scene(root, 700,400));
    }

}