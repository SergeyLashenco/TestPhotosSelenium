package org.example.tests;

import org.example.app.Application;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected static final Application app = new Application(System.getProperty("browser", BrowserType.CHROME));

    @BeforeTest
    public void setUp() {
        app.init();
    }

    @AfterTest
    public void tearDown() {
        app.stop();
    }
}
