package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCities() {

        navPage.getSignUpLink().click();
        navPage.getLoginLink().click();
        loginPage.getInputForEmail().sendKeys("admin@admin.com");
        loginPage.getInputForPassword().sendKeys("12345");
        loginPage.getButtonForLogin().click();

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/cities", "Not on cities page.");
    }

    @Test(priority = 2)
    public void checksInputTypesForCreateEditNewCity() {

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getButtonNewItem().click();
        citiesPage.waitForEditAndCreateDialog();
        Assert.assertEquals(citiesPage.getInputForNameOfCity().getAttribute("type"), "text", "Incorrect attribute type for name of city");

    }

    @Test(priority = 3)
    public void CreateNewCity() throws InterruptedException {

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getButtonNewItem().click();
        citiesPage.waitForEditAndCreateDialog();
        citiesPage.getInputForNameOfCity().sendKeys("Ana Stojkovic's city");
        citiesPage.getSaveButton().click();

        messagePopUpPage.waitForSuccessPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp().getText().contains("Saved successfully"),
                "Incorrect message for verification");

    }

    @Test(priority = 4)
    public void editCity() {

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getInputForSearch().sendKeys("Ana Stojkovic's city");
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButtonByRow(1).click();
        citiesPage.getInputForNameOfCity().sendKeys(Keys.CONTROL+"a");
        citiesPage.getInputForNameOfCity().sendKeys("Ana Stojkovic's city edited");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForSuccessPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp().getText().contains("Saved successfully"), "Incorrect message for verification");

    }
    @Test(priority = 5)
    public void searchCity() {

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getInputForSearch().sendKeys("Ana Stojkovic's city");
        citiesPage.waitForNumberOfRowsToBe(1);

        Assert.assertEquals(citiesPage.getCell(1,1).getText(),"Ana Stojkovic's city edited","Incorrect name of the city");
    }
    @Test(priority = 6)
    public void deleteCity() {

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getInputForSearch().sendKeys("Ana Stojkovic's city edited");
        citiesPage.waitForNumberOfRowsToBe(1);

        Assert.assertEquals(citiesPage.getCell(1,1).getText(),"Ana Stojkovic's city edited","Incorrect name of the city");
        citiesPage.getDeleteButtonByRow(1).click();
        citiesPage.waitForDeleteDialog();
        citiesPage.getDeleteButton().click();

        messagePopUpPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp().getText().contains("Deleted successfully"), "Incorrect message about deleting the name of city");






    }
}
