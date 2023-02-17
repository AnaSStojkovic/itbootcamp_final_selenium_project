package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasicPage{
    public MyProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getInputForMail(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getInputForName(){
        return driver.findElement(By.xpath("//input[@id='name']"));
    }

    public WebElement getInputForPhone(){
        return driver.findElement(By.xpath("//input[@id='phone']"));
    }

    public WebElement getInputForCity(){
        return driver.findElement(By.xpath("//input[@id='city']"));
    }

    public WebElement getInputForCountry(){
        return driver.findElement(By.xpath("//input[@id='country']"));
    }
    public WebElement getInputForTwitter(){
        return driver.findElement(By.xpath("//input[@id='urlTwitter']"));
    }

    public WebElement getInputForGitHub(){
        return driver.findElement(By.xpath("//input[@id='urlGitHub']"));
    }
    public WebElement getSaveButton() {
        return driver.findElement(By.className("btnSave"));
    }

    public WebElement getXButtonForPhone(){
        return driver.findElement(By.className("v-input__icon--clear"));
    }

    public WebElement getXButtonForCity(){
        return driver.findElement(By.className("v-input__append-inner"));
    }

    public void waitProgressBarInvisible() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                By.xpath("//div[@role='progressbar']"))));
    }





}