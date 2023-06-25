package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import javax.xml.transform.Result;
import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    private Button btt;

    @FXML
    private Label outpt;

    @FXML
    private TextField text_here;



    public static double continu(int n) {
        System.out.println(n);
        double res = 0;
        double dev = 1;
        for(double i=0; i<n; i++)
        {
            res=res+1/dev;
            dev=dev*2;
        }
        return res;

    }



    public void display(javafx.event.ActionEvent actionEvent) {

        int n = Integer.parseInt(text_here.getText().toString());

        double res = continu(n);

        System.out.println(res);
        String total2 = String.valueOf(res);
        outpt.setText(total2);
    }
}
