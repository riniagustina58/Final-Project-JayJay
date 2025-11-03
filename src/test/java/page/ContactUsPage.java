package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends Website {

    WebDriver driver;
    WebDriverWait wait;

    By contactMenuButton = By.xpath("//a[normalize-space()='Contact']");
    By contactDialog = By.xpath("//h5[normalize-space()='New message']");
    By inputEmail = By.id("recipient-email");
    By inputName = By.id("recipient-name");
    By inputMessage = By.id("message-text");
    By buttonSend = By.xpath("//button[@onclick='send()']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToHomepage() {
        driver.get(url);
    }

    public void clickContactMenu() {
        driver.findElement(contactMenuButton).click();
    }

    public String onContactDialog() {
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(contactDialog));
        return dialog.getText();
    }

    public void userInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void userInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void userInputMessage(String message) {
        driver.findElement(inputMessage).sendKeys(message);
    }

    public void userClickSend() {
        driver.findElement(buttonSend).click();
    }

    public String alertContact(){
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
}
