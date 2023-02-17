package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHomeLink(){
        return driver.findElement(By.linkText("HOME"));
    }

    public WebElement getAboutLinka(){
        return driver.findElement(By.linkText("ABOUT"));
    }

    public WebElement getMyProfileLink(){
        return driver.findElement(By.linkText("MY PROFILE"));
    }

    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesLink(){
        return driver.findElement(By.linkText("Cities"));
    }
    public WebElement getUsersLink(){
        return driver.findElement(By.linkText("Users"));
    }

    public WebElement getSignUpLink(){
        return driver.findElement(By.linkText("SIGN UP"));
    }

    public WebElement getLoginLink(){
        return driver.findElement(By.linkText("LOGIN"));
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }

    public void waitForLogOutButtonToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnLogout")));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getLanguageButtonEn(){
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement getLanguageButtonEs(){
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getLanguageButtonFr(){
        return driver.findElement(By.className("btnFR"));
    }

    public WebElement getLanguageButtonCn(){
        return driver.findElement(By.className("btnCN"));
    }
    public WebElement getLanguageButtonUa(){
        return driver.findElement(By.className("btnUA"));
    }

    public WebElement getHeader(){
        return driver.findElement(By.tagName("h1"));
    }












}