package lib;

import org.openqa.selenium.WebDriver;
import pages.*;

public class Rozetka {

	public HomePage homePage;
	public LoginPage loginPage;
	public RegistrationPage registrationPage;
    public Cabinet cabinet;
    public PCInset pcinset;
    public ResultOfSearch resultOfSearch;
    public ItemCard itemCard;
    public Cart cart;
    public CheckOut checkOut;
	public Web web;
	static WebDriver driver;

	public Rozetka(WebDriver driver) throws Exception {

		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		registrationPage = new RegistrationPage(driver);
        cabinet = new Cabinet(driver);
        pcinset = new PCInset(driver);
        resultOfSearch = new ResultOfSearch(driver);
        cart = new Cart(driver);
        checkOut = new CheckOut(driver);
        itemCard = new ItemCard(driver);
		web  = new Web(driver);
	}

}
