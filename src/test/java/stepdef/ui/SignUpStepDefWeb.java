package stepdef.ui;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.SignUpPage;
import tools.Generator;

public class SignUpStepDefWeb extends BaseTest {

    SignUpPage signUpPage;

    @Given("user on the homepage")
    public void userOnTheHomepage() {
        signUpPage = new SignUpPage(driver);
        signUpPage.goToHomepage();
    }

    @When("user click sign up menu")
    public void userClickSignUpMenu() {
        signUpPage.clickSignUpMenu();
    }

    @And("user is on login dialog sign up")
    public void userIsOnLoginDialogSignUp() {
        String text = signUpPage.signUpDialog();
        Assert.assertEquals("Sign up", text);
    }

    @And("user input username on  text box with {string}")
    public void userInputUsernameOnTextBoxWith(String username) {
        /*Avoid duplicate userid*/
        String uniqName = Generator.getUniqueVal();
        username = username.replace("???", uniqName);

        signUpPage.userInputUsername(username);
    }

    @And("user input password  on text box with {string}")
    public void userInputPasswordOnTextBoxWith(String password) {
        signUpPage.userInputPassword(password);
    }

    @And("user click sign up button")
    public void userClickSignUpButton() {
        signUpPage.userClickSignUp();
    }

    @Then("show alert message sign up succesfull {string}")
    public void showAlertMessageSignUpSuccesfull(String message) {
        String text = signUpPage.userSuccessSignup();
        Assert.assertEquals(message, text);
    }
}
