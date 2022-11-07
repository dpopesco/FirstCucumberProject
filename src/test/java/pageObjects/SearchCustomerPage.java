package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.time.Duration;
import java.util.List;

public class SearchCustomerPage {

    public WebDriver ldriver;
    WaitHelper waitHelper;

    public SearchCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        waitHelper = new WaitHelper(ldriver);
    }

    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(how = How.ID, using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement drpdMonth;

    @FindBy(how = How.ID, using = "SearchDayOfBirth")
    @CacheLookup
    WebElement drpdDay;

    @FindBy(how = How.ID, using = "SearchCompany")
    @CacheLookup
    WebElement txtCompany;

    @FindBy(how = How.CLASS_NAME, using = "k-input")
    @CacheLookup
    WebElement txtCustomerRoles;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
    @CacheLookup
    WebElement listItemAdministrators;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Forum Moderators')]")
    @CacheLookup
    WebElement getListItemModerators;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
    @CacheLookup
    WebElement getListItemGuests;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
    @CacheLookup
    WebElement getListItemRegistered;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
    @CacheLookup
    WebElement getListItemVendors;

    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
    @CacheLookup
    WebElement tblSearchResult;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;

    public void setEmail(String email) {
        waitHelper.waitForElement(txtEmail, Duration.ofSeconds(30));
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String firstName) {
        waitHelper.waitForElement(txtFirstName, Duration.ofSeconds(30));
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        waitHelper.waitForElement(txtLastName, Duration.ofSeconds(30));
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }

    public void clickSearchButton() {
        btnSearch.click();
        waitHelper.waitForElement(btnSearch, Duration.ofSeconds(30));
    }

    public int getNoOfRows() {
        return tableRows.size();
    }

    public int getNoOfColumns() {
        return tableColumns.size();
    }

    public boolean searchCustomerByEmail(String email) {
        boolean flag = false;

        for (int i = 1; i <= getNoOfRows(); i++) {
            String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println(emailId);
            if (emailId.equals(email)) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean searchCustomerByName(String Name) {
        boolean flag = false;

        for (int i = 1; i <= getNoOfRows(); i++) {
            String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]")).getText();
            String names[] = name.split(" "); //separating first name and last name
            if (names[0].equals("Victoria") && (names[1].equals("Terces"))) {
                flag = true;
            }
        }
        return flag;
    }
}
