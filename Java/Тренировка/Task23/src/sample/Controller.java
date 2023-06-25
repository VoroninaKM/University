package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {

    Tree tree = new Tree();

    @FXML
    private TextField nodeValue;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Label tr;

    public void add(javafx.event.ActionEvent actionEvent){
        tree.insertNode(Integer.parseInt(nodeValue.getText()));
        tr.setText(tree.printTree());
        nodeValue.clear();
    }

    public void delete(javafx.event.ActionEvent actionEvent){
        tree.deleteNode(Integer.parseInt(nodeValue.getText()));
        tr.setText(tree.printTree());
        nodeValue.clear();
    }
}
