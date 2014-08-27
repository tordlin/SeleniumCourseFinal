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
public class CheckOut {
    static Logger log = Logger.getLogger(Web.class);
    static  WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public CheckOut(WebDriver driver)throws IOException {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);

    }

    public void inputPhone(String phone) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!phone.equals(null))
        {web.input("PhoneInputCfield", phone);
            waitForElement.until(ExpectedConditions
                    .textToBePresentInElementLocated(ui("PhoneInputCfield"), phone));
            log.info("input " + phone + " into email field");
        }else{
            Assert.fail();
        }

    }

    public void clickForwardButton() throws Exception{
        web.clickButton("Forward.button");
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("Confirm.button")));
        log.info("click on forward button in Check out");
    }

    public void clickConfirmButton() throws Exception{
        web.clickButton("Confirm.button");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("HomeLogo")));
        log.info("click on confirm button");

    }
}
