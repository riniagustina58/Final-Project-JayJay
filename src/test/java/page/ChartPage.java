package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ChartPage extends Website{
    WebDriver driver;
    WebDriverWait wait;

    By menuCategoryPhone = By.xpath("//a[@id='itemc' and text()='Phones']");
    By onCategoryPhone = By.cssSelector("#tbodyid .card-title a");
    By sampleCategoryPhone = By.xpath("//a[@class='hrefch' and normalize-space(text())='Samsung galaxy s6']");

    By detailProduct = By.xpath("//h2[@class='name']");

    By addToCartButton = By.xpath("//a[normalize-space()='Add to cart']");

    By chartMenuButton = By.xpath("//a[normalize-space()='Cart']");

    By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");

    By orderDialogTitle = By.id("orderModalLabel");

    public ChartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToHomepage() {
        driver.get(url);
    }

    /*phone*/
    public void userClickCategoryPhone(){
        driver.findElement(menuCategoryPhone).click();
    }

    public boolean showCategoryPhoneProduct(String productName){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(onCategoryPhone));
        List<WebElement> products = driver.findElements(onCategoryPhone);
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void userClickSamplePhone(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sampleCategoryPhone));
        driver.findElement(sampleCategoryPhone).click();
    }

    public String showDetailProduct(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(detailProduct));
        return driver.findElement(detailProduct).getText();
    }

    public void addToChart(){
        driver.findElement(addToCartButton).click();
    }

    public String showAlertAddToChart(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText;

        } catch (NoAlertPresentException e) {
            return null;
        }
    }

    public void clickMenuChart(){
        driver.findElement(chartMenuButton).click();
    }

    public boolean userOnCartPage(String productName) {
        By specificProduct = By.xpath("//tbody[@id='tbodyid']//td[normalize-space()='" + productName + "']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(specificProduct));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Product not found in cart within wait time: " + productName);
            return false;
        }
    }

    public void userClickPlaceOrder(){
        driver.findElement(placeOrderButton).click();
    }
    public String userOnOrderDialog(){
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(orderDialogTitle));
        return dialog.getText();
    }
}
