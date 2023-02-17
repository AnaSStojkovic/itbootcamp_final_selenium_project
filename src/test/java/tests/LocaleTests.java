package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1)
    public void setLocaleToEs() throws InterruptedException {

        navPage.getLanguageButton().click();
        navPage.getLanguageButtonEs().click();

        Assert.assertEquals(navPage.getHeader().getText(),"Página de aterrizaje","Incorrect text in header for spanish language.");

    }

    @Test(priority = 2)
    public void setLocaleToEn() throws InterruptedException {

        navPage.getLanguageButton().click();
        navPage.getLanguageButtonEn().click();

        Assert.assertEquals(navPage.getHeader().getText(),"Landing","Incorrect text in header for english language.");

    }
    @Test(priority = 3)
    public void setLocaleToCn() throws InterruptedException {

        navPage.getLanguageButton().click();
        navPage.getLanguageButtonCn().click();

        Assert.assertEquals(navPage.getHeader().getText(),"首页","Incorrect text in header for chinese language.");

    }
    @Test(priority = 4)
    public void setLocaleToFr() throws InterruptedException {

        navPage.getLanguageButton().click();
        navPage.getLanguageButtonFr().click();

        Assert.assertEquals(navPage.getHeader().getText(),"Page d'atterrissage","Incorrect text in header for french language.");

    }


}

