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
public class ResultOfSearch {
    static Logger log = Logger.getLogger(Web.class);
    static  WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public ResultOfSearch(WebDriver driver) throws IOException {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);
        //123
    }

    public void clickItem() throws Exception{
        web.clickLink("ImgItemFromROfS.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("Buy.button")));
        log.info("click on img item from search field inset");
    }
}
