package stepdef.ui;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.AboutUsPage;

public class AboutUsStepDefWeb extends BaseTest{
    AboutUsPage aboutUsPage;

    String title = "";

    @Given("user open homepage about")
    public void userOpenHomePage() {
        aboutUsPage = new AboutUsPage(driver);
        aboutUsPage.goToHomepage();
    }


    @When("user click about menu")
    public void userClickAboutMenu() {
        aboutUsPage.clickAboutMenu();
    }

    @And("user is on about dialog")
    public void userIsOnAboutDialog() {
        title = aboutUsPage.onAboutDialog();
    }

    @Then("validate dialog {string}")
    public void validateDialog(String titleDialog) {
        Assert.assertEquals(titleDialog, title);
    }
}
