package org.sinkelev.tests;

import org.sinkelev.drivers.InitialDriver;
import org.sinkelev.tests.base.BaseTest;
import org.sinkelev.tests.pages.HomePage;
import org.sinkelev.tests.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        InitialDriver.set();
        loginPage = new LoginPage();
    }

    @Test
    public void logInEmailTest() {
        loginPage.installAndOpenApp(APK);
        loginPage.clickEmailEnterBtn();
        Assert.assertTrue(loginPage.checkText("What\u2019s your email?").isDisplayed());

        loginPage.enterEmail()
                .clickNextButton();
        Assert.assertTrue(loginPage.checkText("Welcome back! Log in to your Vivino account").isDisplayed());

        loginPage.enterPassword()
                .clickLogInBtn();
        homePage = loginPage.getMainPage();
        Assert.assertTrue(homePage.searchBtn.isDisplayed());
        Assert.assertTrue(homePage.checkText("Find friends").isDisplayed());
        Assert.assertTrue(homePage.checkText("Top-rated wines").isDisplayed());
        //Assert.assertTrue(homePage.checkText("For you").isDisplayed());
        //Assert.assertTrue(homePage.checkText("Picked for you").isDisplayed());
        //Assert.assertTrue(homePage.checkText("Best wines under 500₽ right now").isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void deleteApp() {
        if (loginPage != null) {
            loginPage.closeSession();
        }
    }
}