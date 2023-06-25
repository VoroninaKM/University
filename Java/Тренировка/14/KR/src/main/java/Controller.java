import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Random;

import java.awt.*;

import static javafx.geometry.Pos.CENTER;

public class Controller {
    @FXML
    private Button generate;

    @FXML
    private TextField start;

    @FXML
    private TextField end;

    @FXML
    private TextField arrayNum;

    @FXML
    void initialize(){
        generate.setOnAction(event -> {
            String minText = start.getText();
            String maxText = end.getText();
            Integer min = Integer.parseInt(minText);
            Integer max = Integer.parseInt(maxText);
            String res1 = result(min, max);
            setText(res1);
        });
    }

    public void setText(String text){
        arrayNum.setText(text);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static String result(int min, int max){
        ArrayList<Integer> res = new ArrayList<Integer>(); // создаем массив результата
        res.add(randInt(min,max));
        res.add(randInt(min,max));
        res.add(randInt(min,max));
        res.add(randInt(min,max));
        res.add(randInt(min,max));

        String text = res.toString();

        return text;
    }
}
