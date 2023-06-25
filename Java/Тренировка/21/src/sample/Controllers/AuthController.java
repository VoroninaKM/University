package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AuthController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label password_field;

    @FXML
    private Label login_field;

    @FXML
    private ImageView auth_image;

    public static final String FILE_PATH = "C:\\Users\\ASUS\\IdeaProjects\\21\\file.txt";

    @FXML
    void initialize() throws MalformedURLException {

        File filemk = new File("C:\\Users\\ASUS\\IdeaProjects\\21\\src\\sample\\windows\\mk.jpg");
        File filetidehunter = new File("C:\\Users\\ASUS\\IdeaProjects\\21\\src\\sample\\windows\\kisspng-dota-2-defense-of-the-ancients-counter-strike-glo-dota-2-transparent-5b45b38918b3b2.4715089415312946011012.jpg");
        File filesniper = new File("C:\\Users\\ASUS\\IdeaProjects\\21\\src\\sample\\windows\\sniper.jpg");
        File filebs = new File("C:\\Users\\ASUS\\IdeaProjects\\21\\src\\sample\\windows\\kisspng-dota-2-the-international-2017-defense-of-the-ancie-5af95f6633d348.8431105315262923262123.jpg");



        try {
            Scanner scanner = new Scanner(new File(FILE_PATH));
            String line = scanner.nextLine();
            String[] data = line.split("#");
            login_field.setText(data[0]);
            password_field.setText(data[1]);
            switch (data[2]) {
                case "MonkeyKing": {
                    String localUrl = filemk.toURI().toURL().toString();
                    Image image = new Image(localUrl);
                    auth_image.setImage(image);
                    break;
                }
                case "Sniper": {
                    String localUrl = filesniper.toURI().toURL().toString();
                    Image image = new Image(localUrl);
                    auth_image.setImage(image);
                    break;
                }
                case "TideHunter": {
                    String localUrl = filetidehunter.toURI().toURL().toString();
                    Image image = new Image(localUrl);
                    auth_image.setImage(image);
                    break;
                }
                case "BloodSeeker":{
                    String localUrl = filebs.toURI().toURL().toString();
                    Image image = new Image(localUrl);
                    auth_image.setImage(image);
                    break;
                }
            }

        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
