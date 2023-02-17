package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {
    @Test(priority = 1)
    public void visitsTheProfilePage() throws InterruptedException {

        navPage.getLoginLink().click();
        loginPage.getInputForEmail().sendKeys("admin@admin.com");
        loginPage.getInputForPassword().sendKeys("12345");
        loginPage.getButtonForLogin().click();

        Assert.assertEquals(loginPage.getInputForEmail().getAttribute("value"), "admin@admin.com", "Incorrect attribute type for email.");

        navPage.getMyProfileLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/profile","Not on profile page.");
        navPage.getLogoutButton().click();
    }

    @Test(priority = 2)
    public void checksInputTypes() throws InterruptedException {

        navPage.getLoginLink().click();
        loginPage.getInputForEmail().sendKeys("admin@admin.com");
        loginPage.getInputForPassword().sendKeys("12345");
        loginPage.getButtonForLogin().click();
        navPage.getMyProfileLink().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        myProfilePage.waitProgressBarInvisible();
        String attrDisabled = (String) js.executeScript("return arguments[0].getAttribute('disabled');", myProfilePage.getInputForMail());
        Assert.assertEquals(attrDisabled,"disabled","Incorrect attribute type for email.");
        Assert.assertEquals(myProfilePage.getInputForMail().getAttribute("type"), "email", "Incorrect attribute type for email.");
        Assert.assertEquals(myProfilePage.getInputForName().getAttribute("type"),"text", "Incorrect attribute type for name.");
        Assert.assertEquals(myProfilePage.getInputForCity().getAttribute("type"),"text","Incorrect attribute type for city.");
        Assert.assertEquals(myProfilePage.getInputForCountry().getAttribute("type"),"text","Incorrect attribute type for country.");
        Assert.assertEquals(myProfilePage.getInputForTwitter().getAttribute("type"),"url","Incorrect attribute type for twiter.");
        Assert.assertEquals(myProfilePage.getInputForGitHub().getAttribute("type"),"url","Incorrect attribute type for git hub.");
        Assert.assertEquals(myProfilePage.getInputForPhone().getAttribute("type"),"tel","Incorrect attribute type for phone.");

        navPage.getLogoutButton().click();
    }


    @Test(priority = 3)
    public void editsProfile() throws InterruptedException {

        navPage.getLoginLink().click();
        loginPage.getInputForEmail().sendKeys("admin@admin.com");
        loginPage.getInputForPassword().sendKeys("12345");
        loginPage.getButtonForLogin().click();
        navPage.getMyProfileLink().click();

        myProfilePage.getInputForName().click();
        myProfilePage.getInputForName().sendKeys(Keys.CONTROL+"a");
        myProfilePage.getInputForName().sendKeys("Ana Stojkovic");

        myProfilePage.getXButtonForPhone();
        myProfilePage.getXButtonForPhone().click();
        myProfilePage.getInputForPhone().sendKeys("+38161283223");

        myProfilePage.getXButtonForCity();
        myProfilePage.getInputForCity().sendKeys("Bucaramanga");

        myProfilePage.getInputForCountry().sendKeys(Keys.CONTROL+"a");
        myProfilePage.getInputForCountry().sendKeys("Spain");

        myProfilePage.getInputForTwitter().sendKeys(Keys.CONTROL+"a");
        myProfilePage.getInputForTwitter().sendKeys("https://twitter.com/profile/milan1232");

        myProfilePage.getInputForGitHub().sendKeys(Keys.CONTROL+"a");
        myProfilePage.getInputForGitHub().sendKeys("https://github.com/anasstojkovic");

        myProfilePage.getSaveButton().click();

        messagePopUpPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp().getText().contains("Profile saved successfuly"),"Incorrect verification success message");

        Assert.assertEquals(myProfilePage.getInputForMail().getAttribute("value"), "admin@admin.com", "Incorrect attribute value for email.");
        Assert.assertEquals(myProfilePage.getInputForName().getAttribute("value"), "Ana Stojkovic", "Incorrect attribute value for name.");
        Assert.assertEquals(myProfilePage.getInputForPhone().getAttribute("value"), "+38161283223", "Incorrect attribute value for phone.");
        Assert.assertEquals(myProfilePage.getInputForCity().getAttribute("value"), "Bucaramanga", "Incorrect attribute value for city.");
        Assert.assertEquals(myProfilePage.getInputForCountry().getAttribute("value"), "Spain", "Incorrect attribute value for country.");
        Assert.assertEquals(myProfilePage.getInputForTwitter().getAttribute("value"), "https://twitter.com/profile/milan1232", "Incorrect attribute value for twiter.");
        Assert.assertEquals(myProfilePage.getInputForGitHub().getAttribute("value"), "https://github.com/anasstojkovic", "Incorrect attribute value for git hub.");

        navPage.getLogoutButton().click();
    }


}