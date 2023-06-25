package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;


class ControllerTest extends ApplicationTest{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    @Test
    public void parallelepipedCalculateTest(){
        clickOn("#a")
                .write("2")
        .clickOn("#b")
                .write("2")
        .clickOn("#c")
                .write("2");
        clickOn("#button");
        FxAssert.verifyThat( "#result", LabeledMatchers.hasText("8.0"));
        System.out.println("OK");

    }

}