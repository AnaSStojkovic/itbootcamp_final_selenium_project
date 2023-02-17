package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasicPage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getInputForEmail(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getInputForPassword(){
        return driver.findElement(By.id("password"));
    }

    public WebElement getButtonForLogin(){
        return driver.findElement(By.xpath("//*[@type='submit']"));
    }

    public void waitForHomePage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnLogout")));

    }


}