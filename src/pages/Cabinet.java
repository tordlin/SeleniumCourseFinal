package pages;

import lib.Web;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static lib.ConfigData.ui;

/**
 * Created by EvgeniyTy on 27.07.2014.
 */
public class Cabinet {
    static Logger log = Logger.getLogger(Web.class);
    static  WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public Cabinet(WebDriver driver)throws IOException {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);
    }
        /*This method click on edit data link*/
    public void clickEditDataLink() throws Exception{
        web.clickLink("EditOwnData.link");
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("InputSurnameField")));
        log.info("click on edit own data");
    }
       /* This method input surname in surname field in edit data form*/
    public void inputSurname(String surname) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!surname.equals(null))
        {web.input("SurnameInputfield", surname);
            waitForElement.until(ExpectedConditions
                    .textToBePresentInElementLocated(ui("SurnameInputfield"), surname));
            log.info("input " + surname + " into name field");
        }else{
            Assert.fail();
        }
    }
    /* This method input phone in phone field in edit data form*/
    public void inputPhone(String phone) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!phone.equals(null))
        {web.input("PhoneInputfield", phone);
            waitForElement.until(ExpectedConditions
                    .textToBePresentInElementLocated(ui("PhoneInputfield"), phone));
            log.info("input " + phone + " into name field");
        }else{
            Assert.fail();
        }
    }
    /* This method input street in street field in edit data form*/
    public void inputStreet(String street) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!street.equals(null))
        {web.input("StreetInputfield", street);
            waitForElement.until(ExpectedConditions
                    .textToBePresentInElementLocated(ui("StreetInputfield"), street));
            log.info("input " + street + " into name field");
        }else{
            Assert.fail();
        }
    }
    /* This method input house in house field in edit data form*/
    public void inputHouse(String house) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if (!house.equals(null)) {
            web.input("HouseInputfield", house);
            waitForElement.until(ExpectedConditions
                    .textToBePresentInElementLocated(ui("HouseInputfield"), house));
            log.info("input " + house + " into name field");
        } else {
            Assert.fail();
        }
    }

    /* This method input apartment in apartment field in edit data form*/
    public void inputApartment(String apartment) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!apartment.equals(null))
        {web.input("ApartmentInputfield", apartment);
            waitForElement.until(ExpectedConditions
                    .textToBePresentInElementLocated(ui("ApartmentInputfield"), apartment));
            log.info("input " + apartment + " into name field");
        }else{
            Assert.fail();
        }
    }
        /*This method save edit data*/
    public void clickSaveButton() throws Exception{
        web.clickButton("SaveEdit.button");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("SaveInformation")));
        log.info("Save edit data");
    }
}
