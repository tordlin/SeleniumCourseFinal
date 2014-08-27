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
public class eCart {
    private WebDriver driver;
    private Rozetka rozetka;
    static Map<String, String> data = new HashMap<String, String>();

    @Before
    public void setUp() throws Exception {
        Util.killAllProcesses();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        rozetka = new Rozetka(driver);
        data = ExcelDriver.getData("src/TestData.xls", "Registration");
    }

    @Test

	  /*
	   * This test serve by cart
	   */
    public void test5() throws Exception {

        //Open Site
        rozetka.web.open ("http://rozetka.com.ua/");

        //go to homePage
        rozetka.homePage.clickHomeLogoLink();

        //go to cart
        rozetka.homePage.clickCartLink();

        //change number of items in cart
        rozetka.cart.clickIncreaseNumber();

        //click on final of order
        rozetka.cart.clickOrderButton();

        //input name in registration form
        rozetka.checkOut.inputPhone(data.get("phone"));

        //click on forward button
        rozetka.checkOut.clickForwardButton();

        //click confirm order
        rozetka.checkOut.clickConfirmButton();

        //go to homePage
        rozetka.homePage.clickHomeLogoLink();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
