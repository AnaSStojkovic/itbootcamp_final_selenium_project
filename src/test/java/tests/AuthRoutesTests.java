package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 1)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() throws InterruptedException {

        driver.get(baseUrl+"/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Not on login page.");
    }

    @Test(priority = 2)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() throws InterruptedException {

        driver.get(baseUrl+"/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Not on login page.");
    }

    @Test(priority = 3)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() throws InterruptedException {

        driver.get(baseUrl+"/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Not on login page.");

    }
    @Test(priority = 4)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {

        driver.get(baseUrl+"/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Not on login page.");

    }
}
