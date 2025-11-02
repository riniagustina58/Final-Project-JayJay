package stepdef.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.SignUpPage;

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
}
