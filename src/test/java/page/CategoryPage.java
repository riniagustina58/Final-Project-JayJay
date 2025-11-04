package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoryPage extends Website {
    WebDriver driver;
    WebDriverWait wait;

    By menuCategoryPhone = By.xpath("//a[@id='itemc' and text()='Phones']");
    By onCategoryPhone = By.cssSelector("#tbodyid .card-title a");
    By sampleCategoryPhone = By.xpath("//a[@class='hrefch' and normalize-space(text())='Samsung galaxy s6']");

    By menuCategoryLaptops = By.xpath("//a[@id='itemc' and text()='Laptops']");
    By onCategoryLaptops = By.cssSelector("#tbodyid .card-title a");
    By sampleCategoryLaptops = By.xpath("//a[@class='hrefch' and normalize-space(text())='Sony vaio i5']");

    By menuCategoryMonitors = By.xpath("//a[@id='itemc' and text()='Monitors']");
    By onCategoryMonitors = By.cssSelector("#tbodyid .card-title a");
    By sampleCategoryMonitors = By.xpath("//a[@class='hrefch' and normalize-space(text())='Apple monitor 24']");

    By detailProduct = By.xpath("//h2[@class='name']");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void goToHomepage() {
        driver.get(url);
    }

    /* ========== Phones ========== */
    public void userClickCategoryPhone() {
        clickWithRetry(menuCategoryPhone);
        waitForCategoryToLoad(onCategoryPhone);
    }

    public boolean showCategoryPhoneProduct(String productName) {
        waitForCategoryToLoad(onCategoryPhone);
        return checkProductExists(onCategoryPhone, productName);
    }

    public void userClickSamplePhone() {
        clickWithRetry(sampleCategoryPhone);
    }

    /* ========== Laptops ========== */
    public void userClickCategoryLaptops() {
        clickWithRetry(menuCategoryLaptops);
        waitForCategoryToLoad(onCategoryLaptops);
    }

    public boolean showCategoryLaptopsProduct(String productName) {
        waitForCategoryToLoad(onCategoryLaptops);
        return checkProductExists(onCategoryLaptops, productName);
    }

    public void userClickSampleLaptops() {
        clickWithRetry(sampleCategoryLaptops);
    }

    /* ========== Monitors ========== */
    public void userClickCategoryMonitors() {
        clickWithRetry(menuCategoryMonitors);
        waitForCategoryToLoad(onCategoryMonitors);
    }

    public boolean showCategoryMonitorsProduct(String productName) {
        waitForCategoryToLoad(onCategoryMonitors);
        return checkProductExists(onCategoryMonitors, productName);
    }

    public void userClickSampleMonitors() {
        clickWithRetry(sampleCategoryMonitors);
    }

    /* ========== Product Detail ========== */
    public String showDetailProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(detailProduct));
        return driver.findElement(detailProduct).getText();
    }

    /* ========== Utility ========== */

    private void clickWithRetry(By locator) {
        int retries = 0;
        while (retries < 3) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("⚠️ Stale element retry (" + (retries + 1) + "): " + locator);
                retries++;
                sleep(500);
            } catch (TimeoutException e) {
                System.out.println("⚠️ Timeout waiting for element: " + locator);
                retries++;
                sleep(500);
            }
        }
        throw new RuntimeException("Failed to click element after retries: " + locator);
    }

    private void waitForCategoryToLoad(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            sleep(500); // beri jeda ringan biar stabil
        } catch (TimeoutException e) {
            System.out.println("⏳ Timeout waiting for elements: " + locator);
        }
    }

    private boolean checkProductExists(By locator, String productName) {
        try {
            List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            for (WebElement product : products) {
                try {
                    if (product.getText().equalsIgnoreCase(productName)) {
                        return true;
                    }
                } catch (StaleElementReferenceException e) {
                    System.out.println("⚠️ Product element stale, retrying check...");
                    return checkProductExists(locator, productName);
                }
            }
        } catch (Exception e) {
            System.out.println("⚠️ Exception checking products: " + e.getMessage());
        }
        return false;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }
}