package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;
    WebDriverWait wait;


    By signUpButton = By.xpath("//a[@id='signin2' and text()='Sign up']");
    By signUpDialog = By.id("signInModalLabel");

//    By loginMenuButton = By.id("login2");
//    By loginDialog = By.id("logInModalLabel");
//    By usernameInputText = By.id("loginusername");
//    By passwordInputText = By.id("loginpassword");
//    By loginButton = By.xpath("//button[text()='Log in']");
//    By homePageLogin = By.id("nameofuser");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait up to 10s
    }

    public void goToHomepage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickSignUpMenu() {
        driver.findElement(signUpButton).click();
    }

    public String signUpDialog() {
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpDialog));
        return dialog.getText();
    }
}
