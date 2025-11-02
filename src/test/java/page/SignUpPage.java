package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends Website{
    WebDriver driver;
    WebDriverWait wait;


    By signUpButton = By.xpath("//a[@id='signin2' and text()='Sign up']");
    By signUpDialog = By.id("signInModalLabel");
    By usernameInputText = By.id("sign-username");
    By passwordInputText = By.id("sign-password");
    By createUser = By.xpath("//button[normalize-space()='Sign up']");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait up to 10s
    }

    public void goToHomepage() {
        driver.get(url);
    }

    public void clickSignUpMenu() {
        driver.findElement(signUpButton).click();
    }

    public String signUpDialog() {
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpDialog));
        return dialog.getText();
    }
    public void userInputUsername(String username){
        driver.findElement(usernameInputText).sendKeys(username);
    }
    public void userInputPassword(String password){
        driver.findElement(passwordInputText).sendKeys(password);
    }
    public void userClickSignUp(){
        driver.findElement(createUser).click();
    }

    public String userSuccessSignup(){
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
