package sample;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javax.script.ScriptException;
import org.apache.commons.lang3.math.NumberUtils;


public class Controller {

    @FXML
    private TextField firstInput;

    @FXML
    private TextField secondInput;

    @FXML
    private TextField fieldOutput;

    @FXML
    private Label errorMessage;

    @FXML
    private Button clearBtn;

    @FXML
    private Button equals;


    private Double result;


    public void setBtnEquals() throws ScriptException {
        if ( NumberUtils.isNumber(firstInput.getText()) && NumberUtils.isNumber(secondInput.getText()) ){
            Double r1 = Double.parseDouble( firstInput.getText() );
            Double r2 = Double.parseDouble( secondInput.getText() );
            errorMessage.setText("");
            result = r1+r2;
            firstInput.clear();
            secondInput.clear();
            fieldOutput.clear();
            fieldOutput.appendText(result.toString());
        }
        else {
            errorMessage.setText("введенное значение должно быть числом");
            fieldOutput.clear();
        }

    }

    public void setClearBtn (ActionEvent event) {
        this.firstInput.clear();
        this.secondInput.clear();
        this.fieldOutput.clear();
    }
}