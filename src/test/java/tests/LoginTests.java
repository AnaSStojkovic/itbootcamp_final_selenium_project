package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{

    @Test(priority = 1)
    public void visitsTheLoginPage(){

        navPage.getLanguageButton().click();
        navPage.getLanguageButtonEn().click();
        navPage.getLoginLink().click();

        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/login","Not on login page.");

    }

    @Test (priority = 2)
    public void checksInputTypes(){

        navPage.getLoginLink().click();

        Assert.assertEquals(loginPage.getInputForEmail().getAttribute("type"),"email","Incorrect attribute type for email.");
        Assert.assertEquals(loginPage.getInputForPassword().getAttribute("type"),"password","Incorrect attribute type for password.");

    }

    @Test (priority = 3)
    public void displaysErrorsWhenUserDoesNotExist(){

        navPage.getLoginLink().click();
        loginPage.getInputForEmail().sendKeys("non-existing-user@gmal.com");
        loginPage.getInputForPassword().sendKeys("password123");
        loginPage.getButtonForLogin().click();
        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getElementsWithTextOfMessage().getText().contains("User does not exists"),"Error is not displayed when credentials are invalid");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/login","Not on login page.");
    }

    @Test (priority = 4)
    public void displaysErrorsWhenPasswordIsWrong(){

        navPage.getLoginLink().click();
        loginPage.getInputForEmail().sendKeys("admin@admin.com");
        loginPage.getInputForPassword().sendKeys("password123");
        loginPage.getButtonForLogin().click();
        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getElementsWithTextOfMessage().getText().contains("Wrong password"),"Error is not displayed when credentials are invalid");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/login","Not on login page.");
    }

    @Test (priority = 5)
    public void logIn() throws InterruptedException {

        navPage.getLoginLink().click();
        loginPage.getInputForEmail().sendKeys("admin@admin.com");
        loginPage.getInputForPassword().sendKeys("12345");
        loginPage.getButtonForLogin().click();
        loginPage.waitForHomePage();

        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/home","Not on home page.");
    }
    @Test(priority = 6)
    public void logout() throws InterruptedException {

        navPage.waitForLogOutButtonToBeVisible();
        navPage.getLogoutButton().click();



    }



}
