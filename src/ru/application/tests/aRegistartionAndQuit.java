package ru.application.tests;

/**
 * Created by EvgeniyTy on 27.07.2014.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import lib.ExcelDriver;
import lib.Util;
import lib.Rozetka;


public class aRegistartionAndQuit {
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
	   * This test open main page and registration
	   */
    public void test1() throws Exception {

        //Open Site
        rozetka.web.open ("http://rozetka.com.ua/");

        //go to login menu
        rozetka.homePage.clickLoginLink();

        //go to registration menu
        rozetka.loginPage.clickRegistrationLink();

        //input name in registration form
        rozetka.registrationPage.inputName(data.get("name"));

        //input email in registration form
        rozetka.registrationPage.inputEmail(data.get("email"));

        //input pass in registration form
        rozetka.registrationPage.inputPass(data.get("pass"));

        //click to registration button
        rozetka.registrationPage.clickRegistrationButton();

        //go to edit own data
        rozetka.cabinet.clickEditDataLink();

        //input surname in registration form
        rozetka.cabinet.inputSurname(data.get("surname"));

        //input phone in registration form
        rozetka.cabinet.inputPhone(data.get("phone"));

        //input street in registration form
        rozetka.cabinet.inputStreet(data.get("street"));

        //input house in registration form
        rozetka.cabinet.inputHouse(data.get("house"));

        //input apartment in registration form
        rozetka.cabinet.inputApartment(data.get("apartment"));

        //save change in own data
        rozetka.cabinet.clickSaveButton();

        //logout from account
        rozetka.homePage.clickLogoutLink();

        //go to homePage
        rozetka.homePage.clickHomeLogoLink();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
