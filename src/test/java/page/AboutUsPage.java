package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutUsPage extends  Website{

    WebDriver driver;
    WebDriverWait wait;

    By aboutMenuButton = By.xpath("//a[normalize-space()='About us']");
    By aboutDialog = By.id("videoModalLabel");

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToHomepage() {
        driver.get(url);
    }

    public void clickAboutMenu() {
        driver.findElement(aboutMenuButton).click();
    }

    public String onAboutDialog() {
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutDialog));
        return dialog.getText();
    }
}
