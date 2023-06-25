package org.kr13.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class firstController {

    @FXML
    private TextField inputMes;

    @FXML
    private Button codeInputButton;

    @FXML
    void inputCode(MouseEvent event) {

    }

    public static List<File> lst = new ArrayList<>();;

    public void input() throws SQLException, ClassNotFoundException, IOException {
        String path = inputMes.getText();
        File dir = new File(path); //path указывает на директорию
        //List<File> lst = new ArrayList<>();
        for ( File file : dir.listFiles() ){
            if ( file.isFile() )
                lst.add(file);
        }

//        Parent root = FXMLLoader.load(getClass().getResource("/resources/org.kr13/second.fxml"));
//        Stage window = (Stage) codeInputButton.getScene().getWindow();
//        window.setScene(new Scene(root, 700,400));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/org.kr13/second.fxml"));
        Parent root = (Parent) loader.load();
        secondController controller = loader.getController();
        controller.loadData();
        Stage window = (Stage) codeInputButton.getScene().getWindow();
        window.setScene(new Scene(root, 700,400));
    }

}