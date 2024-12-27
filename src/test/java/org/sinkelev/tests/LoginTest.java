package org.sinkelev.tests;

import org.sinkelev.tests.pages.HomePage;
import org.sinkelev.tests.pages.LoginPage;
import org.sinkelev.utils.DriverManager;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        DriverManager.installAndOpenApp();
    }

    @Test
    public void logInEmailTest() {
        loginPage.clickEmailEnterBtn();
        Assert.assertTrue(loginPage.checkText("What’s your email?").isDisplayed());

        loginPage.enterEmail()
                .clickNextButton();
        Assert.assertTrue(loginPage.checkText("Welcome back! Log in to your Vivino account").isDisplayed());

        loginPage.enterPassword()
                .clickLogInBtn();
        homePage = loginPage.getMainPage();
        Assert.assertTrue(homePage.checkText("For you").isDisplayed());
        Assert.assertTrue(homePage.checkText("Picked for you").isDisplayed());
        Assert.assertTrue(homePage.checkText("Best wines under 500₽ right now").isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}