package stepdef.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks extends BaseTest {
    @Before("@web")
    public void beforeTest() {
        getDriver();
    }

    @After("@web")
    public void AfterTest() {
        driver.close();
    }
}
