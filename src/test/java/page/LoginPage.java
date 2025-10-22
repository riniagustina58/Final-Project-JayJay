package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdef.ui.BaseTest;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By loginMenuButton = By.id("login2");
    By loginDialog = By.id("logInModalLabel");
    By usernameInputText = By.id("loginusername");
    By passwordInputText = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");
    By homePageLogin = By.id("nameofuser");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait up to 10s
    }

    public void goToHomepage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickLoginMenu() {
        driver.findElement(loginMenuButton).click();
    }

    public String loginDialog() {
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(loginDialog));
        return dialog.getText();
    }

    public void inputUsername (String username) {
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword (String pass) {
        driver.findElement(passwordInputText).sendKeys(pass);
    }

    public void clickLoginButton (){
        driver.findElement(loginButton).click();
    }

    public String homePageLogin (){
        WebElement welcomeText = wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLogin));
        return welcomeText.getText();
    }

    public String alertWrongPassword(){
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

    public String alertUserDoesNotExist(){
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
