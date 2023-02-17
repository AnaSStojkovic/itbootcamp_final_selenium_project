package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getInputForName(){
        return driver.findElement(By.id("name"));
    }

    public WebElement getInputForEmail(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getInputForPassword(){
        return driver.findElement(By.id("password"));
    }

    public WebElement getInputForConfirmPassword(){
        return driver.findElement(By.id("confirmPassword"));
    }

    public WebElement getButtonSignMeUp(){
        return driver.findElement(By.xpath("//*[@type='submit']"));
    }



}