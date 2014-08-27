package lib;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static lib.ConfigData.*;
import static org.junit.Assert.assertEquals;

/**
 * Class that provides most frequently used steps for working with elements on Web pages
 */
public class Web {
	static Logger log = Logger.getLogger(Web.class);
	public static String screenshotFileFolder = "log/screenshot/";
	WebDriver driver;

	public Web(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	/*
	 * Open URL in a browser and verify page title
	 */
	public void open(String url) throws ClassNotFoundException, IOException,
			InstantiationException, IllegalAccessException {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getCfgValue("WAIT_PAGE_LOAD")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		//assertEquals(homePageTitle, driver.getTitle());
		//driver.switchTo().frame(0);
	}

	/*
	 * Open site in browser
	 */
	public void openSite() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		open(getCfgValue("SITE_URL"));
		
		
	}

	/*
	 * Close the browser
	 */
	public void quit() {
		driver.quit();
	}

	/*
	 * Click a button
	 */
	public void clickButton(String buttonLocator) throws ClassNotFoundException, IOException, InstantiationException,
			IllegalAccessException {
		driver.findElement(ui(buttonLocator)).click();
	}

	/*
	 * Insert value into text input HTML field
	 */
	public void input(String inputLocator, String inputData) throws ClassNotFoundException, IOException,
			InstantiationException, IllegalAccessException {
		driver.findElement(ui(inputLocator)).clear();
		driver.findElement(ui(inputLocator)).sendKeys(inputData);
	}

	/*
	 * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression
	 */

	public void inputAndClickEnter(String inputLocator, String inputData) throws Exception, InstantiationException,
			IllegalAccessException, InterruptedException {
		driver.findElement(ui(inputLocator)).clear();
		driver.findElement(ui(inputLocator)).sendKeys(inputData);
		driver.findElement(ui(inputLocator)).sendKeys(Keys.ENTER);
	}

	/*
	 * Select value from drop down list
	 */
	public void selectFromList(String listLocator, String listValue) throws IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		new Select(driver.findElement(ui(listLocator))).selectByVisibleText(listValue);
	}

	/*
	 * Check/uncheck the checkbox, the second parameter should be "Y" or "N"
	 */
	public void selectCheckbox(String checkboxLocator, String isSet) throws ClassNotFoundException, IOException,
			InstantiationException, IllegalAccessException {
		if (driver.findElement(ui(checkboxLocator)).isSelected() & isSet.equals("N")) {
			driver.findElement(ui(checkboxLocator)).click();
		}
		;

		if (!driver.findElement(ui(checkboxLocator)).isSelected() & isSet.equals("Y")) {
			driver.findElement(ui(checkboxLocator)).click();
		}
		;
	}

	/*
	 * Wait the text in the element specified time
	 */
	public void waitTextPresent(By elementLocator, int timeoutInS, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInS);
			wait.until(ExpectedConditions.textToBePresentInElement(elementLocator, text));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Wait the text in the element value specified time
	 */

	public void waitTextPresentInElementValue(By elementLocator, int timeoutInS, String text) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInS);
			wait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, text));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Click link
	 */
	public void clickLink(String linkLocator) throws ClassNotFoundException, IOException, InstantiationException,
			IllegalAccessException {
		driver.findElement(ui(linkLocator)).click();
	}

	/*
	 * Method is used to check that element is present on page.
	 */
	 public boolean isElementPresent(String elementLocator) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		  try {
		   driver.findElement(ui(elementLocator));
		  } catch (org.openqa.selenium.NoSuchElementException Ex) {
		   return false;
		  }
		  return true;
		 }

	/*
	 * Wait the element on page specified time
	 */
	public void waitElementNotVisible(String elementLocator, int timeoutInS) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInS);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(ui(elementLocator)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * This method is used to get text from pop-up windows
	  */
	 public String getAlertText() {
	  String alertText = new String();
	  try {
	   Alert alert = driver.switchTo().alert();
	   alertText = alert.getText();
	   alert.accept();
	   log.info("Alert text: " + alertText);
	  } catch (NoAlertPresentException ex) {
	   alertText = "Alert is not found";
	   log.info("Alert is not found");
	   // ex.printStackTrace();
	  }
	  return alertText;
	 }
	
	 /*
	  * Check if the test failed or not and complete the test.
	  */
	 public static void testResult(boolean isTestPassed) {
	  if (!isTestPassed) {
	   log.error("TEST FAILED");
	   Assert.fail();
	  }
	  log.info("TEST SUCCESSFULLY COMPLETED");

	 }

	/**
	 * This method is used to agree messages on pop-up windows
	 */
	public boolean isAlertPresent() {
		boolean alertPresence = false;
		try {
			Alert alert = driver.switchTo().alert();
			alertPresence = true;
			alert.accept();
		} catch (NoAlertPresentException ex) {
			// ex.printStackTrace();
		}
		return alertPresence;
	}

	/**
	 * This method is used to wait for getting response from all Ajax requests
	 */
	public boolean waitForAjaxResponse(int timeoutSeconds) throws InterruptedException {
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

			for (int i = 0; i < timeoutSeconds; i++) {
				Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.active");
				if (numberOfConnections instanceof Long) {
					//log.debug("Number of active jQuery Ajax calls is <" + numberOfConnections + ">");

					if (numberOfConnections == 0)
						break;
				}
				// stay(1);
			}
			return false;
		} else {
			//log.info("Web Driver: <" + driver + "> cann't execute JavaScript");
			return false;
		}
	}

}
