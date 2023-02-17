package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 1)
    public void visitsTheSignupPage(){

        navPage.getSignUpLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup","Not on signup page.");

    }

    @Test(priority = 2)
    public void checkInputTypes(){

        navPage.getSignUpLink().click();
        Assert.assertEquals(signupPage.getInputForEmail().getAttribute("type"),"email","Incorrect attribute type for email.");
        Assert.assertEquals(signupPage.getInputForPassword().getAttribute("type"),"password","Incorrect attribute type for password.");
        Assert.assertEquals(signupPage.getInputForConfirmPassword().getAttribute("type"),"password","Incorrect attribute type for password.");

    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserAlreadyExists(){

        navPage.getSignUpLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup","Not on signup page.");

        signupPage.getInputForName().sendKeys("Another User");
        signupPage.getInputForEmail().sendKeys("admin@admin.com");
        signupPage.getInputForPassword().sendKeys("12345");
        signupPage.getInputForConfirmPassword().sendKeys("12345");
        signupPage.getButtonSignMeUp().click();

        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getElementsWithTextOfMessage().getText().contains("E-mail already exists"),"Error is not displayed when credentials are invalid");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup","Not on signup page.");

    }

    @Test(priority = 4)
    public void signUp() throws InterruptedException {

        navPage.getSignUpLink().click();
        signupPage.getInputForName().sendKeys("Ana Stojkovic");
        signupPage.getInputForEmail().sendKeys("ana.stojkovic@itbootcamp.rs");
        signupPage.getInputForPassword().sendKeys("12345");
        signupPage.getInputForConfirmPassword().sendKeys("12345");
        signupPage.getButtonSignMeUp().click();

        driver.get(baseUrl+"/home");
        messagePopUpPage.waitForVerifyBoxToBeVisible();

        Assert.assertTrue(messagePopUpPage.getElementWithTextFromVerifyBox().getText().contains("IMPORTANT: Verify your account"),"Incorrect message for verification");
        messagePopUpPage.getCloseButtonFromVerifyBox().click();
        navPage.getLogoutButton();

    }
}
