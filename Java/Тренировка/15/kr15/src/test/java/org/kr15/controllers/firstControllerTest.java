package org.kr15.controllers;

import junit.framework.TestCase;
import org.junit.*;

import java.io.IOException;
import java.sql.SQLException;

public class firstControllerTest extends TestCase {



    private firstController fContr;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before firstControllerTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After firstControllerTest.class");
    }

    @Before
    public void initTest() throws IOException {
        fContr = new firstController();
    }

    @After
    public void afterTest() {
        fContr = null;
    }

    @Test
    public void testInput() throws SQLException, IOException, ClassNotFoundException {
        fContr.input();
    }


    @Ignore("Message for ignored test")
    @Test
    public void ignoredTest() {
        System.out.println("will not print it");
    }

//    @Test(timeout = 500)
//    public void timeStampTest() {
//        while (true);
//    }
}