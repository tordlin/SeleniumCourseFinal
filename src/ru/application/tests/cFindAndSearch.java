package ru.application.tests;

import lib.ExcelDriver;
import lib.Rozetka;
import lib.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.PCInset;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by EvgeniyTy on 27.07.2014.
 */
public class cFindAndSearch {

    private WebDriver driver;
    private Rozetka rozetka;
    static Map<String, String> data = new HashMap<String, String>();



    @Before
    public void setUp() throws Exception {
        Util.killAllProcesses();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        rozetka = new Rozetka(driver);
    }

    @Test

	  /*
	   * This test find item in inset and find this item by search
	   */
    public void test3() throws Exception {

        //Open Site
        rozetka.web.open ("http://rozetka.com.ua/");

        //go to homePage
        rozetka.homePage.clickHomeLogoLink();

        //go to PC inset by link
        rozetka.homePage.clickPCInset();

        //go to software inset by link
        rozetka.pcinset.clickSoftwareLink();

        //go to SAPR inset by link
        rozetka.pcinset.clickSAPRwareLink();

        //go to item card
        rozetka.pcinset.clickItemCard();

        //save name of item
        rozetka.itemCard.saveItemName();

        //go to homePage
        rozetka.homePage.clickHomeLogoLink();

        //input name of item in search field
        rozetka.homePage.inputItemNameInSearch("Autodesk AutoCAD LT 2015 Commercial New SLM 5-Pack");

        //click on search button
        rozetka.homePage.clickSearchButton();

        //click on item from result of search
        rozetka.resultOfSearch.clickItem();


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
