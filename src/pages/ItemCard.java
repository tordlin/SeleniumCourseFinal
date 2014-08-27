package pages;

import lib.Web;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static lib.ConfigData.ui;

/**
 * Created by EvgeniyTy on 27.07.2014.
 */
public class ItemCard {
    static Logger log = Logger.getLogger(Web.class);
    static  WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public ItemCard(WebDriver driver) throws IOException {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);
        
    }

    public void clickCharacteristicsInset() throws Exception{
        web.clickLink("Characteristics.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("CharacteristicsTitle")));
        log.info("click on Characteristics inset");
    }

    public void clickPhotoInset() throws Exception{
        web.clickLink("PhotoInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("PhotoInsetTitle")));
        log.info("click on Photo inset");
    }

    public void clickCommentsInset() throws Exception{
        web.clickLink("CommentsInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("CommentsInsetTitle")));
        log.info("click on Comments inset");
    }

    public void clickDeliveryInset() throws Exception{
        web.clickLink("DeliveryInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("DeliveryInsetTitle")));
        log.info("click on Delivery inset");
    }

    public void clickAllInset() throws Exception{
        web.clickLink("AllInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("AllInsetTitle")));
        log.info("click on All inset");
    }

    public void saveItemName() throws Exception{
    }

    public void clickShareVKLink() throws Exception{
        web.clickLink("VKShare.link");
        //switch to
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("VKPost.button")));
        log.info("click on VK share link");

        web.clickLink("VKPost.button");
        //switch to
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("HomeLogo")));
        log.info("click on post button");
    }

    public void clickBuyButton() throws Exception{
        web.clickButton("Buy.button");
        //switch to
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("QuitFromPop.button")));
        log.info("click on order button");

        web.clickButton("QuitFromPop.button");
        //switch to
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("HomeLogo")));
        log.info("click on quit button in pop up menu");
    }
}
