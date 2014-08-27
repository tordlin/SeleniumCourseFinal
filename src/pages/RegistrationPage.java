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
public class RegistrationPage {
    static Logger log = Logger.getLogger(Web.class);
    static  WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public RegistrationPage(WebDriver driver)throws IOException {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);
    }
        /*This method input name in name field in registration form*/
    public void inputName(String name) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!name.equals(null))
        {web.input("NameInputfield", name);
            //waitForElement.until(ExpectedConditions
            //        .textToBePresentInElementLocated(ui("NameInputfield"), name));
            log.info("input " + name + " into name field");
        }else{
            Assert.fail();
        }
    }
    /*This method input email in email field in registration form*/
    public void inputEmail(String email) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!email.equals(null))
        {web.input("EmailInputRfield", email);
           // waitForElement.until(ExpectedConditions
           //         .textToBePresentInElementLocated(ui("EmailInputRfield"), email));
            log.info("input " + email + " into email field");
        }else{
            Assert.fail();
        }
    }
    /*This method input pass in pass field in registration form*/
    public void inputPass(String pass) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!pass.equals(null))
        {web.input("PassInputRfield", pass);
            //waitForElement.until(ExpectedConditions
            //        .textToBePresentInElementLocated(ui("PassInputRfield"), pass));
            log.info("input " + pass + " into pass field");
        }else{
            Assert.fail();
        }
    }
        /*This method click on registration button*/
    public void clickRegistrationButton() throws Exception{
        web.clickButton("Registration.button");
        waitForElement.until(ExpectedConditions.elementToBeClickable(ui("EditOwnData.link")));
        log.info("click on registration button");
    }
}
