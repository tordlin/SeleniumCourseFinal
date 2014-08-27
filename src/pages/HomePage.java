package pages;

import lib.Web;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static lib.ConfigData.ui;

/**
 * Created by EvgeniyTy on 27.07.2014.
 */

public class HomePage {
    static Logger log = Logger.getLogger(Web.class);
    static  WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public HomePage(WebDriver driver)throws Exception {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);
    }
        /*This method click by login link in home page*/
    public void clickLoginLink() throws Exception {
        web.clickLink("Login.link");
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("Registration.link")));
        log.info("click on login link");
    }
        /*This method logout*/
    public void clickLogoutLink() throws Exception{
        web.clickLink("Logout.link");
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("Login.link")));
        log.info("click on logout link");
    }
        /*This method click on home logo*/
    public void clickHomeLogoLink() throws Exception{
        web.clickLink("HomeLogo");
        waitForElement.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(ui("HomeLogo"))));
        log.info("click on home logo");
    }

    public void clickPCInset() throws Exception{
        web.clickLink("PCInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("PCInsetTitle")));
        log.info("click on PC inset");
    }

    public void clickPhoneInset() throws Exception{
        web.clickLink("PhoneInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("PhoneInsetTitle")));
        log.info("click on phone inset");
    }

    public void clickAudioInset() throws Exception{
        web.clickLink("AudioInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("AudioInsetTitle")));
        log.info("click on audio inset");
    }

    public void clickKitchenInset() throws Exception{
        web.clickLink("KitchenInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("KitchenInsetTitle")));
        log.info("click on kitchen inset");
    }

    public void clickRestInset() throws Exception{
        web.clickLink("RestInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("RestInsetTitle")));
        log.info("click on rest inset");
    }

    public void clickChildInset() throws Exception{
        web.clickLink("ChildInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("ChildInsetTitle")));
        log.info("click on child inset");
    }

    public void clickHomeInset() throws Exception{
        web.clickLink("HomeInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("HomeInsetTitle")));
        log.info("click on home inset");
    }

    public void clickAutoInset() throws Exception{
        web.clickLink("AutoInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("AutoInsetTitle")));
        log.info("click on auto inset");
    }

    public void clickTicketInset() throws Exception{
        web.clickLink("TicketInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("TicketInsetForm")));
        log.info("click on ticket inset");
    }

    public void clickClothesInset() throws Exception{
        web.clickLink("ClothesInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("ClothesInsetTitle")));
        log.info("click on clothes inset");
    }

    public void inputItemNameInSearch(String itemName) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!itemName.equals(null))
        {web.input("PassInputLfield", itemName);
            waitForElement.until(ExpectedConditions
                    .textToBePresentInElementLocated(ui("PassInputLfield"), itemName));
            log.info("input " + itemName + " into pass field");
        }else {
            Assert.fail();
        }
    }

    public void clickSearchButton() throws Exception{
        web.clickButton("Search.button");
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("SearchResult")));
        log.info("click on search button");
    }

    public void clickCartLink() throws Exception{
        web.clickLink("Cart.link");
        //swith to
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("QuitFromPop")));
        log.info("click on cart link");
    }
}
