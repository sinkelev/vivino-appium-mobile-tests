package org.sinkelev.tests;

import org.sinkelev.drivers.InitialDriver;
import org.sinkelev.tests.base.BaseTest;
import org.sinkelev.tests.pages.HomePage;
import org.sinkelev.tests.pages.LoginPage;
import org.sinkelev.tests.pages.SearchPage;
import org.sinkelev.tests.pages.WineDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private SearchPage searchPage;
    private WineDetailsPage wineDetailsPage;

    @BeforeMethod
    public void setUp() {
        InitialDriver.set();
        loginPage = new LoginPage();
    }

    @Test
    public void searchOpenTest() {
        loginPage.installAndOpenApp(APK);
        loginPage.clickEmailEnterBtn();
        Assert.assertTrue(loginPage.checkText("What\u2019s your email?").isDisplayed());

        loginPage.enterEmail()
                .clickNextButton();
        Assert.assertTrue(loginPage.checkText("Welcome back! Log in to your Vivino account").isDisplayed());

        loginPage.enterPassword()
                .clickLogInBtn();
        homePage = loginPage.getMainPage();
        Assert.assertTrue(homePage.searchInput.isDisplayed());
        Assert.assertTrue(homePage.checkText("Find friends").isDisplayed());
        Assert.assertTrue(homePage.checkText("Top-rated wines").isDisplayed());

        homePage.clickSearchInput();
        searchPage = homePage.getSearchPage();
        Assert.assertTrue(searchPage.searchInput.isDisplayed());
        Assert.assertTrue(searchPage.allWinesBtn.isDisplayed());
        Assert.assertTrue(searchPage.myWinesBtn.isDisplayed());
        Assert.assertTrue(searchPage.peopleBtn.isDisplayed());
    }

    @Test
    public void searchVineTest() {
        loginPage.installAndOpenApp(APK);
        loginPage.clickEmailEnterBtn();
        Assert.assertTrue(loginPage.checkText("What\u2019s your email?").isDisplayed());

        loginPage.enterEmail()
                .clickNextButton();
        Assert.assertTrue(loginPage.checkText("Welcome back! Log in to your Vivino account").isDisplayed());

        loginPage.enterPassword()
                .clickLogInBtn();
        homePage = loginPage.getMainPage();
        Assert.assertTrue(homePage.searchInput.isDisplayed());
        Assert.assertTrue(homePage.checkText("Find friends").isDisplayed());
        Assert.assertTrue(homePage.checkText("Top-rated wines").isDisplayed());

        homePage.clickSearchInput();
        searchPage = homePage.getSearchPage();
        Assert.assertTrue(searchPage.searchInput.isDisplayed());
        Assert.assertTrue(searchPage.allWinesBtn.isDisplayed());
        Assert.assertTrue(searchPage.myWinesBtn.isDisplayed());
        Assert.assertTrue(searchPage.peopleBtn.isDisplayed());

        searchPage.enterWine("Matsu");
        Assert.assertTrue(homePage.checkText("Matsu").isDisplayed());
        Assert.assertTrue(homePage.checkText("El Picaro").isDisplayed());
    }

    @Test
    public void searchVineDetailTest() {
        loginPage.installAndOpenApp(APK);
        loginPage.clickEmailEnterBtn();
        Assert.assertTrue(loginPage.checkText("What\u2019s your email?").isDisplayed());

        loginPage.enterEmail()
                .clickNextButton();
        Assert.assertTrue(loginPage.checkText("Welcome back! Log in to your Vivino account").isDisplayed());

        loginPage.enterPassword()
                .clickLogInBtn();
        homePage = loginPage.getMainPage();
        Assert.assertTrue(homePage.searchInput.isDisplayed());
        Assert.assertTrue(homePage.checkText("Find friends").isDisplayed());
        Assert.assertTrue(homePage.checkText("Top-rated wines").isDisplayed());

        homePage.clickSearchInput();
        searchPage = homePage.getSearchPage();
        Assert.assertTrue(searchPage.searchInput.isDisplayed());
        Assert.assertTrue(searchPage.allWinesBtn.isDisplayed());
        Assert.assertTrue(searchPage.myWinesBtn.isDisplayed());
        Assert.assertTrue(searchPage.peopleBtn.isDisplayed());

        searchPage.enterWine("Matsu");
        Assert.assertTrue(homePage.checkText("Matsu").isDisplayed());
        Assert.assertTrue(homePage.checkText("El Picaro").isDisplayed());

        searchPage.clickText("El Picaro");
        wineDetailsPage = searchPage.getWineDetailsPage();
        Assert.assertTrue(wineDetailsPage.starsRating.isDisplayed());
        Assert.assertTrue(wineDetailsPage.ratingCount.isDisplayed());
        Assert.assertTrue(wineDetailsPage.avgPriceValue.isDisplayed());
        Assert.assertTrue(wineDetailsPage.avgPriceLabel.isDisplayed());
        Assert.assertTrue(wineDetailsPage.checkText("Matsu").isDisplayed());
        Assert.assertTrue(wineDetailsPage.checkText("El Picaro").isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void deleteApp() {
        if (loginPage != null) {
            loginPage.closeSession();
        }
    }
}