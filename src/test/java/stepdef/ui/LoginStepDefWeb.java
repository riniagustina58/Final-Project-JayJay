package stepdef.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.LoginPage;

public class LoginStepDefWeb extends BaseTest {

    LoginPage loginPage;

    @Given("user open homepage")
    public void userOpenHomePage() {
        loginPage = new LoginPage(driver);

        loginPage.goToHomepage();
    }

    @When("user click login menu")
    public void userClickLoginMenu() {
        loginPage.clickLoginMenu();

    }

    @And("user is on login dialog")
    public void userIsOnLoginDialog() {
        String text = loginPage.loginDialog();
        Assert.assertEquals("Log in", text);
    }

    @And("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password pada text box with {string}")
    public void userInputPasswordPadaTextBoxWith(String pass) {
        loginPage.inputPassword(pass);
    }

    @And("user click login button")
    public void userClickLoginButton() {

        loginPage.clickLoginButton();

    }

    @Then("user is on homepage {string}")
    public void userIsOnHomepage(String username) {
        String text = loginPage.homePageLogin();

        String expected = "Welcome "+ username;
        Assert.assertEquals(expected, text);

    }

    @Then("show alert wrong password {string}")
    public void showAlertWrongPassword(String alert) {
        String alertText = loginPage.alertWrongPassword();
        Assert.assertEquals(alertText, alert);
    }

    @Then("show alert user does not exist {string}")
    public void showAlertUserDoesNotExist(String alert1) {
        String alertText = loginPage.alertUserDoesNotExist();
        Assert.assertEquals(alertText, alert1);
    }
}
