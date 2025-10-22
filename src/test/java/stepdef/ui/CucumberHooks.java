package stepdef.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks extends BaseTest {
    @Before("@ui")
    public void beforeTest() {
        getDriver();
    }

    @After("@ui")
    public void AfterTest() {
        driver.close();
    }
}
