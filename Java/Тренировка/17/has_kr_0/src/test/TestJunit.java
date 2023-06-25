package test;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import sample.Controller;

import static org.junit.Assert.assertEquals;

public class TestJunit {
    private Controller calc_test;

    @Test
    @DisplayName("Simple multiplication should work")

    @BeforeEach
    public void setUp() throws Exception {
        calc_test = new Controller();
    }

    @Test
    public void test_Number(){

        assertEquals("check",1.875,calc_test.continu(4),0.0);
        //assertEquals("check",0.0,Controller.continu(4),0.0);

    }

}