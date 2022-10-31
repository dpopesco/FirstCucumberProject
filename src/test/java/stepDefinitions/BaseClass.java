package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage lp;
    public AddCustomerPage addCustomer;

    public static String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
}
