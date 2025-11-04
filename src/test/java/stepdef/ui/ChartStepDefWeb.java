package stepdef.ui;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.CategoryPage;
import page.ChartPage;
import page.Website;

public class ChartStepDefWeb extends BaseTest {
    ChartPage chartPage;

    @Given("user open homepage for checkout")
    public void userOpenHomePage() {
        chartPage = new ChartPage(driver);
        chartPage.goToHomepage();
    }


    @When("user click category phone for checkout")
    public void userClickCategoryPhoneForCheckout() {
        chartPage.userClickCategoryPhone();
    }

    @And("show category phone product for checkout {string}")
    public void showCategoryPhoneProductForCheckout(String product) {
        boolean stat = chartPage.showCategoryPhoneProduct(product);
        Assert.assertTrue(stat);
    }

    @And("user click one product for checkout")
    public void userClickOneProductForCheckout() {
        chartPage.userClickSamplePhone();
    }

    @And("show detail product for checkout {string}")
    public void showDetailProductForCheckout(String product) {
        String text = chartPage.showDetailProduct();
        Assert.assertTrue(text.toLowerCase().contains(product.toLowerCase()));
    }

    @And("add to chart")
    public void addToChart() {
        chartPage.addToChart();
    }

    @Then("show Alert success {string}")
    public void showAlertSuccess(String message) {
        String text = chartPage.showAlertAddToChart();
        Assert.assertEquals(message,text);
    }


    @And("user click menu chart")
    public void userClickMenuChart() {
        chartPage.clickMenuChart();
    }

    @When("user on chart page {string};")
    public void userOnChartPage(String productName) {
        boolean stat = chartPage.userOnCartPage(productName);
        Assert.assertTrue(stat);
    }

    @And("User click place order")
    public void userClickPlaceOrder() {
        chartPage.userClickPlaceOrder();
    }

    @And("User On Checkout dialog {string}")
    public void userOnCheckoutDialog(String title) {
        String text = chartPage.userOnOrderDialog();
        Assert.assertEquals(title, text);
    }

    @And("User input Place order information {string} {string} {string} {string} {string} {string}")
    public void userInputPlaceOrderInformation(String name, String country, String city, String creditCard, String month, String year) {
        chartPage.inputPlaceOrder(name, country, city, creditCard, month, year);
    }

    @And("User click Purchase button")
    public void userClickPurchaseButton() {
        chartPage.clickPurchaseButton();
    }

    @Then("checkout completed succes and show alert {string}")
    public void checkoutCompletedSuccesAndShowAlert(String message) {
        String text = chartPage.onCompletedPage();
        Assert.assertEquals(message, text);
    }
}
