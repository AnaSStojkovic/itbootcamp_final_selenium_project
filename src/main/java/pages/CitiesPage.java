package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CitiesPage extends BasicPage {

    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getButtonNewItem(){
        return driver.findElement(By.className("btnNewItem"));
    }

    public void waitForEditAndCreateDialog(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }

    public WebElement getInputForNameOfCity(){
        return driver.findElement(By.id("name"));
    }
    public void waitForDeleteDialog(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("body-1")));
    }

    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }
    public WebElement getDeleteButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'red--text')]"));

    }
    public List<WebElement> waitForNumberOfRowsToBe(int rows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions
                .numberOfElementsToBe(By.tagName("tr"), rows+1));
    }

    public WebElement getCell(int row, int column) {
        return driver.findElement(
                By.xpath("//tbody/tr["+row+"]/td["+(column+1)+"]"));
    }

    public WebElement getEditButtonByRow(int row) {
        return driver.findElement(
                By.xpath("//tbody/tr["+row+"]/td/div/button[@id='edit']"));
    }

    public WebElement getDeleteButtonByRow(int row) {
        return driver.findElement(
                By.xpath("//tbody/tr["+row+"]/td/div/button[@id='delete']"));
    }

    public WebElement getInputForSearch(){
        return driver.findElement(By.id("search"));

    }

}