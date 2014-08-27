package ru.application.tests;

import lib.ExcelDriver;
import lib.Rozetka;
import lib.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by EvgeniyTy on 27.07.2014.
 */
public class bLoginAndServe {

    private WebDriver driver;
    private Rozetka rozetka;
    static Map<String, String> data = new HashMap<String, String>();



    @Before
    public void setUp() throws Exception {
        Util.killAllProcesses();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        rozetka = new Rozetka(driver);
        data = ExcelDriver.getData("src/TestData.xls", "Login");
    }

    @Test

	  /*
	   * This test login and serve
	   */
    public void test2() throws Exception {

        //Open Site
        rozetka.web.open ("http://rozetka.com.ua/");

        //go to homePage
        //rozetka.homePage.clickHomeLogoLink();

        //go to login menu
        rozetka.homePage.clickLoginLink();

        //input email in login form
        rozetka.loginPage.inputEmail(data.get("email"));

        //input pass in login form
        rozetka.loginPage.inputPass(data.get("pass"));

        //check remember me in login form
        rozetka.loginPage.checkRememberMe();

        //click on login button
        rozetka.loginPage.clickLoginButton();

        //go to PC inset by link
        rozetka.homePage.clickPCInset();

        //go to phone inset by link
        rozetka.homePage.clickPhoneInset();

        //go to audio inset by link
        rozetka.homePage.clickAudioInset();

        //go to kitchen inset by link
        rozetka.homePage.clickKitchenInset();

        //go to rest inset by link
        rozetka.homePage.clickRestInset();

        //go to child inset by link
        rozetka.homePage.clickChildInset();

        //go to home inset by link
        rozetka.homePage.clickHomeInset();

        //go to auto inset by link
        rozetka.homePage.clickAutoInset();

        //go to ticket inset by link
        rozetka.homePage.clickTicketInset();

        //go to auto clothes by link
        rozetka.homePage.clickClothesInset();

        //go to homePage
        rozetka.homePage.clickHomeLogoLink();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
