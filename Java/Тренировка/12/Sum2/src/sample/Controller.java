package sample;
import java.io.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField file_url;

    @FXML
    private Button but;

    @FXML
    private Text res;

    @FXML
    void initialize() {
        but.setOnAction(actionEvent -> {
            File file = new File(file_url.getText());
//            File file = new File("E:/SumFile/src/sample/input.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String str;
                int count = 0;
                int sum = 0;
                while ((str = br.readLine()) != null) {
                    sum += Integer.parseInt(str);
                    count++;
                }
                res.setText(String.format("%.3f", (double) sum/count));
            } catch (FileNotFoundException e) {
                res.setText("File " + file.toString() + " is not found!");
            } catch (IOException e) {
                res.setText("Unable to read this file!");
            }
        });
    }
}
