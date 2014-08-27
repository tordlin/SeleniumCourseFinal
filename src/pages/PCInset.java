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
public class PCInset {
    static Logger log = Logger.getLogger(Web.class);
    static  WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public PCInset(WebDriver driver) throws IOException {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);

    }

    public void clickSoftwareLink() throws Exception{
        web.clickLink("PCInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("PCInsetTitle")));
        log.info("click on PC inset link");
    }

    public void clickSAPRwareLink() throws Exception{
        web.clickLink("SAPRInset.link");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("SAPRnsetTitle")));
        log.info("click on SAPR inset link");
    }

    public void clickItemCard() throws Exception{
        web.clickLink("ImgItem");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("Order.button")));
        log.info("click on img item");
    }
}
