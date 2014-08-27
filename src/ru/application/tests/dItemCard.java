package ru.application.tests;

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
public class dItemCard {
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
	   * This test serve by item card
	   */
    public void test4() throws Exception {

        //Open Site
        rozetka.web.open ("http://rozetka.com.ua/");

        //go to homePage
        rozetka.homePage.clickHomeLogoLink();

        //input name of item in search field
        rozetka.homePage.inputItemNameInSearch("Autodesk AutoCAD LT 2015 Commercial New SLM 5-Pack");

        //click on search button
        rozetka.homePage.clickSearchButton();

        //click on item from result of search
        rozetka.resultOfSearch.clickItem();

        //go to characteristics in item card
        rozetka.itemCard.clickCharacteristicsInset();

        //go to photo in item card
        rozetka.itemCard.clickPhotoInset();

        //go to comments in item card
        rozetka.itemCard.clickCommentsInset();

        //go to delivery in item card
        rozetka.itemCard.clickDeliveryInset();

        //go to all in item card
        rozetka.itemCard.clickAllInset();

        //click on share with friend by vkontakte
        rozetka.itemCard.clickShareVKLink();

        //click on buy button
        rozetka.itemCard.clickBuyButton();

        //go to homePage
        rozetka.homePage.clickHomeLogoLink();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
