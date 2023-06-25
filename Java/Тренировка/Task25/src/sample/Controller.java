package sample;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private String result;
    @FXML
    private TextField Aa;
    @FXML
    private TextField Ab;
    @FXML
    private TextField Ba;
    @FXML
    private TextField Bb;
    @FXML
    private TextField res;
    @FXML
    private Button summation;
    @FXML
    private Button subtract;
    @FXML
    private Button multiply;
    double aa;
    double ab;
    double ba;
    double bb;
    Calcul x;
    Calcul y;
    Calcul z;


    public void parameters(){
        aa = Double.parseDouble(Aa.getText());
        ab = Double.parseDouble(Ab.getText());
        ba = Double.parseDouble(Ba.getText());
        bb = Double.parseDouble(Bb.getText());
        x = new Calcul(aa, ab);
        y = new Calcul(ba, bb);
    }

    public void sum(javafx.event.ActionEvent actionEvent){
        parameters();
        z = Calcul.sum(x, y);
        result = String.valueOf(z);
        res.setText(result);
    }

    public void sub(javafx.event.ActionEvent actionEvent){
        parameters();
        z = Calcul.subtract(x, y);
        result = String.valueOf(z);
        res.setText(result);
    }

    public void mul(javafx.event.ActionEvent actionEvent){
        parameters();
        z = Calcul.multiply(x, y);
        result = String.valueOf(z);
        res.setText(result);
    }

}
