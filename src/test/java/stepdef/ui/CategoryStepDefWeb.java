package stepdef.ui;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.CategoryPage;

public class CategoryStepDefWeb extends BaseTest {

    CategoryPage categoryPage;

    @Given("user open homepage product")
    public void userOpenHomePage() {
        categoryPage = new CategoryPage(driver);
        categoryPage.goToHomepage();
    }

    @When("user click category phone")
    public void userClickCategoryPhone() {
        categoryPage.userClickCategoryPhone();
    }

    @And("show category phone product {string}")
    public void showCategoryPhoneProduct(String productPhone)  {
        boolean stat = categoryPage.showCategoryPhoneProduct(productPhone);
        Assert.assertTrue(stat);
    }

    @And("user click one product")
    public void userClickOneProduct() {
        categoryPage.userClickSamplePhone();
    }

    @Then("show detail product {string}")
    public void showDetailProduct(String productName) {
        String text = categoryPage.showDetailProduct();
        Assert.assertTrue(text.toLowerCase().contains(productName.toLowerCase()));
    }


    /*laptop*/
    @When("user click category laptops")
    public void userClickCategoryLaptops() {
        categoryPage.userClickCategoryLaptops();
    }

    @And("show category laptops product {string}")
    public void showCategoryLaptopsProduct(String productLaptop) {
        boolean stat = categoryPage.showCategoryLaptopsProduct(productLaptop);
        Assert.assertTrue(stat);
    }

    @And("user click one product laptops")
    public void userClickOneProductLaptops() {
        categoryPage.userClickSampleLaptops();
    }

    /*Monitor*/
    @When("user click category monitor")
    public void userClickCategoryMonitor() {
        categoryPage.userClickCategoryMonitors();
    }

    @And("show category monitor product {string}")
    public void showCategoryMonitorProduct(String productMonitor) {
        boolean stat = categoryPage.showCategoryMonitorsProduct(productMonitor);
        Assert.assertTrue(stat);
    }

    @And("user click one product monitor")
    public void userClickOneProductMonitor() {
        categoryPage.userClickSampleMonitors();
    }


}
