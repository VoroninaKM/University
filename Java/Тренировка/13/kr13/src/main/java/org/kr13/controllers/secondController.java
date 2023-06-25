package org.kr13.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class secondController {
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private ListView<String> fileList;

    void loadData(){
        list.removeAll(list);
        for (int j = 0; firstController.lst.size() > j; j++){
            list.add(firstController.lst.get(j));
        }
        fileList.getItems().addAll(list);
    }
}

