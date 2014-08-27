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
public class Cart {
    static Logger log = Logger.getLogger(Web.class);
    static WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public Cart(WebDriver driver) throws IOException {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);

    }

    public void clickIncreaseNumber() throws Exception {
        web.clickButton("UpArrow.button");
        //waitForElement.until(ExpectedConditions.elementToBeClickable(ui("QuitFromPop.button")));
        log.info("click on button which increase number of item");
    }

    public void clickOrderButton() throws Exception {
        web.clickButton("Order.button");
        //switch to
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("CheckOutTitle")));
        log.info("click on order button");
    }
}
