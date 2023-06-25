package sample;
import java.io.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Этот класс по введённой дате
 * выводит номер недели на экран.
 * <p>
 * @author  ФИО
 * @version 0.1
 * @since   31.05.2021
 */

public class Controller {
    @FXML
    private TextField date_inp;

    @FXML
    private Button but;

    @FXML
    private Text res;

    /**
     * Главный и единственный метод
     * реализующий логику программы
     */
    @FXML
    void initialize() throws Exception {
        but.setOnAction(actionEvent -> {
            try {
                Date date1=new SimpleDateFormat("dd.MM.yy").parse(date_inp.getText());
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date1);
                res.setText(String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR)));
                System.out.println("Week number:" + calendar.get(Calendar.WEEK_OF_YEAR));
            }
            catch (Exception e) {
                res.setText("Ошибка");
            }
        });
    }
}
