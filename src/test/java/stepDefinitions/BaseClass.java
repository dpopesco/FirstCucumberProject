package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.Properties;


public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage lp;
    public AddCustomerPage addCustomer;
    public SearchCustomerPage searchCustomer;
    public static Logger logger;
    public Properties configProperties;

    public static String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
}
