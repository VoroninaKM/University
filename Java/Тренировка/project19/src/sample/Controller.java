package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    /**
     Рекурсивная функция нахождения факториала. На вход подаётся number
     @param number - число
     */
    public static long factorial(long number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField number_field;

    @FXML
    private Button button;

    @FXML
    private Label res_fac;

    /**
     Параметр number получает данные от поля number_field
     */
    @FXML
    void initialize() {
        button.setOnAction(event -> {
            try {
                long number = Long.parseLong(number_field.getText());
                res_fac.setText(Long.toString(factorial(number)));
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Данные введены не корректно. Попробуйте снова!");
                }
        });
    }
}
