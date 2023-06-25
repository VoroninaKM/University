package sample;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button button;

    @FXML
    private TextField input;

    @FXML
    private TextField input1;

    @FXML
    private TextField answer;


    // When user click on myButton
    // this method will be called.
    public void onClickButton(ActionEvent event) {
        // Show in VIEW
        int a = Integer.parseInt(input.getText());
        int b = Integer.parseInt(input1.getText());
        if (a < b ) {
            answer.setText(String.valueOf(this.getList(a , b)));
        }

    }

    public static List<Integer> getList(int f, int g) {
        List<Integer> array = new ArrayList<>();
        for (int i = f; i <= g; i++) {
            if ( i % 2 == 0 && i > 0  && i / 10 >= 1 && i / 10 <= 9 )
            {
                array.add(i);
            }
        }
        return array;
    }
}