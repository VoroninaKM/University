package tests;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.*;
import org.testfx.util.WaitForAsyncUtils;
import sample.Main;

import java.io.IOException;

public class UnitTest extends ApplicationTest {
    Pane mainroot;
    Stage mainstage;

    @Override
    public void start (Stage stage) throws IOException {
        mainroot = (Pane) FXMLLoader.load(Main.class.getResource("sample.fxml"));
        mainstage = stage;
        stage.setScene(new Scene(mainroot));
        stage.show();
        stage.toFront();

    }

    @Test
    public void forConsistent () {
        /*
        позитивный сценарий - вводятся два числа
         */

        clickOn("#firstInput");
        write("14");
        clickOn("#secondInput");
        write("5");
        clickOn("#equals");
        WaitForAsyncUtils.waitForFxEvents();
        FxAssert.verifyThat( "#fieldOutput", TextInputControlMatchers.hasText("19.0"));
        System.out.println("ok");

    }

    @Test
    public void firstInputIsNotANumber () {
        /*
        негативный сценарий - вводится не число в первый input
         */
        clickOn("#firstInput");
        write("");
        clickOn("#secondInput");
        write("5");
        clickOn("#equals");
        WaitForAsyncUtils.waitForFxEvents();
        FxAssert.verifyThat( "#errorMessage", LabeledMatchers.hasText("введенное значение должно быть числом"));
        System.out.println("ok for nothing in the first place");

        clickOn("#clearBtn");

        clickOn("#firstInput");
        write(" ");
        clickOn("#secondInput");
        write("5");
        clickOn("#equals");
        WaitForAsyncUtils.waitForFxEvents();
        FxAssert.verifyThat( "#errorMessage", LabeledMatchers.hasText("введенное значение должно быть числом"));
        System.out.println("ok for space in the first place");

        clickOn("#clearBtn");

        clickOn("#firstInput");
        write("jj");
        clickOn("#secondInput");
        write("5");
        clickOn("#equals");
        WaitForAsyncUtils.waitForFxEvents();
        FxAssert.verifyThat( "#errorMessage", LabeledMatchers.hasText("введенное значение должно быть числом"));
        System.out.println("ok for letter in the first place");

    }

    @Test
    public void secInputIsNotANumber () {
        /*
        негативный сценарий - вводится не число (пробел, буква) во второй input
         */
        clickOn("#firstInput");
        write("14");
        clickOn("#secondInput");
        write("");
        clickOn("#equals");
        WaitForAsyncUtils.waitForFxEvents();
        FxAssert.verifyThat( "#errorMessage", LabeledMatchers.hasText("введенное значение должно быть числом"));
        System.out.println("ok for nothing in the second place");

        clickOn("#clearBtn");

        clickOn("#firstInput");
        write("14");
        clickOn("#secondInput");
        write(" ");
        clickOn("#equals");
        WaitForAsyncUtils.waitForFxEvents();
        FxAssert.verifyThat( "#errorMessage", LabeledMatchers.hasText("введенное значение должно быть числом"));
        System.out.println("ok for space in the second place");

        clickOn("#clearBtn");

        clickOn("#firstInput");
        write("14");
        clickOn("#secondInput");
        write("jj");
        clickOn("#equals");
        WaitForAsyncUtils.waitForFxEvents();
        FxAssert.verifyThat( "#errorMessage", LabeledMatchers.hasText("введенное значение должно быть числом"));
        System.out.println("ok for letter in the second place");

    }
}