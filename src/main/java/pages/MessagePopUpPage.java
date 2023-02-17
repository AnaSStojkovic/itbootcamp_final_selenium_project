package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage extends BasicPage {

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForPopUpToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public WebElement getElementsWithTextOfMessage(){
        return driver.findElement(By.className("v-snack__wrapper")).findElement(By.tagName("li"));
    }

    public void waitForVerifyBoxToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'dlgVerifyAccount')]")));
    }
    public WebElement getElementWithTextFromVerifyBox(){
        return this.driver.findElement(By.xpath(
                "//div[contains(@class, 'dlgVerifyAccount')]"));
    }
    public WebElement getCloseButtonFromVerifyBox(){
        return driver.
                findElement(By.className("btnClose"));
    }
    public void waitForSuccessPopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'success')]")));
    }

    public WebElement getMessageFromSuccessPopUp() {
        return this.driver.findElement(By.xpath(
                "//div[contains(@class, 'success')]"));
    }




}
