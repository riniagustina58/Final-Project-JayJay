package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoryPage extends Website{
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


    public CategoryPage(WebDriver driver){
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



    /*Laptops*/

    public void userClickCategoryLaptops(){
        driver.findElement(menuCategoryLaptops).click();
    }

    public boolean showCategoryLaptopsProduct(String productName){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(onCategoryLaptops));
        List<WebElement> products = driver.findElements(onCategoryLaptops);
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void userClickSampleLaptops(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sampleCategoryLaptops));
        driver.findElement(sampleCategoryLaptops).click();
    }


    /*Monitors*/
    public void userClickCategoryMonitors(){
        driver.findElement(menuCategoryMonitors).click();
    }

    public boolean showCategoryMonitorsProduct(String productName){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(onCategoryMonitors));
        List<WebElement> products = driver.findElements(onCategoryMonitors);
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void userClickSampleMonitors(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sampleCategoryMonitors));
        driver.findElement(sampleCategoryMonitors).click();
    }

    public String showDetailProduct(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(detailProduct));
        return driver.findElement(detailProduct).getText();
    }

}
