package stepdef.ui;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.AboutUsPage;
import page.ContactUsPage;

public class ContactStepDefWeb extends BaseTest{
    ContactUsPage contactUsPage;

    String title = "";

    @Given("user open homepage contact")
    public void userOpenHomePage() {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.goToHomepage();
    }

    @When("user click contact menu")
    public void userClickContactMenu() {
        contactUsPage.clickContactMenu();
    }

    @And("user is on contct dialog")
    public void userIsOnContctDialog() {
        title = contactUsPage.onContactDialog();
    }

    @Then("validate dialog contact {string}")
    public void validateDialogContact(String titlePage) {
        Assert.assertEquals(titlePage, title);
    }


    @And("user insert email {string}")
    public void userInsertEmail(String email) {
        contactUsPage.userInputEmail(email);
    }

    @And("user insert contact name {string}")
    public void userInsertContactName(String name) {
        contactUsPage.userInputName(name);
    }

    @And("user insert message {string}")
    public void userInsertMessage(String message) {
        contactUsPage.userInputMessage(message);
    }

    @And("user click send")
    public void userClickSend() {
        contactUsPage.userClickSend();
    }

    @Then("message already send, show alert {string}")
    public void messageAlreadySendShowAlert(String messageAlert) {
        String text = contactUsPage.alertContact();
        Assert.assertEquals(messageAlert, text);

    }
}
