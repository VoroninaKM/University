package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void factorial() {
        long actual = Controller.factorial(5);
        long excepted = 120;
        assertEquals(excepted, actual);
    }
}