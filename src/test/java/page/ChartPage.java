package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ChartPage extends Website {
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
    By purchaseButton = By.xpath("//button[normalize-space()='Purchase']");

    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By creditCardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By successMessage = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");

    public ChartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // diperpanjang untuk stabilitas
    }

    public void goToHomepage() {
        driver.get(url);
    }

    /* PHONE */
    public void userClickCategoryPhone() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuCategoryPhone));
        menu.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(onCategoryPhone));
    }

    public boolean showCategoryPhoneProduct(String productName) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(onCategoryPhone));
            List<WebElement> products = driver.findElements(onCategoryPhone);
            for (WebElement product : products) {
                if (product.getText().equalsIgnoreCase(productName)) {
                    return true;
                }
            }
        } catch (TimeoutException e) {
            System.out.println("⚠️ Timeout: Product list not loaded yet for Phones.");
        }
        return false;
    }

    public void userClickSamplePhone() {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(sampleCategoryPhone));
        product.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(detailProduct));
    }

    public String showDetailProduct() {
        WebElement detail = wait.until(ExpectedConditions.visibilityOfElementLocated(detailProduct));
        return detail.getText();
    }

    public void addToChart() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addBtn.click();
    }

    public String showAlertAddToChart() {
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (TimeoutException | NoAlertPresentException e) {
            System.out.println("⚠️ No alert appeared after Add to cart.");
            return null;
        }
    }

    public void clickMenuChart() {
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(chartMenuButton));
        cartBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
    }

    public boolean userOnCartPage(String productName) {
        By specificProduct = By.xpath("//tbody[@id='tbodyid']//td[normalize-space()='" + productName + "']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(specificProduct));
            return true;
        } catch (TimeoutException e) {
            System.out.println("⚠️ Product not found in cart: " + productName);
            return false;
        }
    }

    public void userClickPlaceOrder() {
        WebElement orderBtn = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        orderBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderDialogTitle));
    }

    public String userOnOrderDialog() {
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(orderDialogTitle));
        return dialog.getText();
    }

    public void inputPlaceOrder(String name, String country, String city, String creditCard, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryField)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardField)).sendKeys(creditCard);
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthField)).sendKeys(month);
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearField)).sendKeys(year);
    }

    public void clickPurchaseButton() {
        WebElement purchaseBtn = wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
        purchaseBtn.click();
    }

    public String onCompletedPage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText();
    }
}