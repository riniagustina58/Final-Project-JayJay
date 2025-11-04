package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends Website {
    WebDriver driver;
    WebDriverWait wait;

    By signUpButton = By.xpath("//a[@id='signin2' and normalize-space(text())='Sign up']");
    By signUpDialog = By.id("signInModalLabel");
    By usernameInputText = By.id("sign-username");
    By passwordInputText = By.id("sign-password");
    By createUser = By.xpath("//button[normalize-space()='Sign up']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // stabil waktu tunggu
    }

    public void goToHomepage() {
        driver.get(url);
    }

    /** Klik tombol menu Sign Up */
    public void clickSignUpMenu() {
        try {
            WebElement signUpBtn = wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
            signUpBtn.click();

            // Tunggu dialog muncul
            waitForDialogToAppear();
        } catch (TimeoutException e) {
            System.out.println("⚠️ Timeout: Sign up button not clickable or dialog not visible.");
        } catch (StaleElementReferenceException e) {
            System.out.println("⚠️ Element refreshed, retry clicking Sign Up button.");
            driver.findElement(signUpButton).click();
            waitForDialogToAppear();
        }
    }

    /** Tunggu modal dialog Sign Up muncul */
    private void waitForDialogToAppear() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(signUpDialog));
            wait.until(ExpectedConditions.visibilityOfElementLocated(signUpDialog));
        } catch (TimeoutException e) {
            System.out.println("⚠️ Timeout: Sign up dialog did not appear.");
        }
    }

    /** Ambil teks judul dari modal dialog */
    public String signUpDialog() {
        waitForDialogToAppear();
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpDialog));
        return dialog.getText();
    }

    /** Input username dengan tunggu hingga elemen siap */
    public void userInputUsername(String username) {
        try {
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText));
            usernameField.clear();
            usernameField.sendKeys(username);
        } catch (TimeoutException e) {
            System.out.println("⚠️ Timeout: Username field not visible.");
        }
    }

    /** Input password dengan tunggu hingga elemen siap */
    public void userInputPassword(String password) {
        try {
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputText));
            passwordField.clear();
            passwordField.sendKeys(password);
        } catch (TimeoutException e) {
            System.out.println("⚠️ Timeout: Password field not visible.");
        }
    }

    /** Klik tombol "Sign up" di dalam dialog */
    public void userClickSignUp() {
        try {
            WebElement createBtn = wait.until(ExpectedConditions.elementToBeClickable(createUser));
            createBtn.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("⚠️ Element refreshed, retry clicking Sign up button.");
            driver.findElement(createUser).click();
        } catch (TimeoutException e) {
            System.out.println("⚠️ Timeout: Sign up button not clickable.");
        }
    }

    /** Menangani alert sukses signup */
    public String userSuccessSignup() {
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            alertWait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (TimeoutException e) {
            System.out.println("⚠️ Timeout: No alert appeared after signup.");
            return null;
        } catch (NoAlertPresentException e) {
            System.out.println("⚠️ No alert found.");
            return null;
        }
    }
}