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
public class LoginPage {

    static Logger log = Logger.getLogger(Web.class);
    static  WebDriver driver;
    Web web;
    WebDriverWait waitForElement;

    public LoginPage(WebDriver driver)throws IOException {
        this.driver = driver;
        web = new Web(driver);
        waitForElement = new WebDriverWait(driver, 10);
    }
        /*This method click by registration link in login menu*/
    public void clickRegistrationLink() throws Exception{
        web.clickLink("Registration.link");
		waitForElement.until(ExpectedConditions.elementToBeClickable(ui("Registration.button")));
        log.info("click to link of registration");
    }

        /*This method input email in email field*/
    public void inputEmail(String email) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!email.equals(null))
        {web.input("EmailInputLfield", email);
            //waitForElement.until(ExpectedConditions
            //        .textToBePresentInElementLocated(ui("EmailInputLfield"), email));
            log.info("input " + email + " into email field");
        }else{
            Assert.fail();
        }
    }
    /*This method input pass in email field*/
    public void inputPass(String pass) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if(!pass.equals(null))
        {web.input("PassInputLfield", pass);
            //waitForElement.until(ExpectedConditions
            //        .textToBePresentInElementLocated(ui("PassInputLfield"), pass));
            log.info("input " + pass + " into pass field");
        }else{
            Assert.fail();
        }
    }
        /*This method check yes in checkbox in login menu*/
    public void checkRememberMe() throws Exception{
        web.selectCheckbox("Distribution.checkbox", "Y");
        waitForElement.until(ExpectedConditions.elementToBeSelected(ui("Distribution.checkbox")));
        log.info("select Yes in checkbox");
    }

    public void clickLoginButton() throws Exception{
        web.clickButton("Login.button");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(ui("AccountName")));
        log.info("click on login button");
    }


}

