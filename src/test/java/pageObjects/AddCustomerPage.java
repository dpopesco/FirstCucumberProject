package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    By lnkCustomersMenu = By.xpath("//a[@href='#']/p[contains(text(),'Customers')]");
    By lnkCustomersMenuItem = By.xpath("//a[@href='/Admin/Customer/List']");

    By btnAddNew = By.xpath("//a[@href='/Admin/Customer/Create']");

    By txtEmail = By.id("Email");
    By txtPassword = By.id("Password");

    By txtChildCustomerRoles = By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']");

    By listItemAdmins = By.xpath("//li[contains(text(),'Administrators')]");
    By listItemModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
    By listItemRegistered = By.xpath("//li[contains(text(),'Registered')]");
    By listItemGuests = By.xpath("//li[contains(text(),'Guests')]");
    By listItemVendors = By.xpath("//li[contains(text(),'Vendors')]");

    By drpOfVendor = By.id("VendorId");
    By rdMaleGender = By.id("Gender_Male");
    By rdFemaleGender = By.id("Gender_Female");

    By txtFirstName = By.id("FirstName");
    By txtLastName = By.id("LastName");

    By txtDateOfBirth = By.id("DateOfBirth");

    By txtCompanyName = By.id("Company");

    By txtAdminComment = By.id("AdminComment");

    By btnSave = By.name("save");

    //Actions Methods

    public String getPageTitle() {
        return ldriver.getTitle();
    }

    public void clickOnCustomersMenu() {
        ldriver.findElement(lnkCustomersMenu).click();
    }

    public void clickOnCustomersMenuItem() {
        ldriver.findElement(lnkCustomersMenuItem).click();
    }

    public void clickOnAddNew() {
        ldriver.findElement(btnAddNew).click();
    }

    public void setEmail(String email) {
        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setCustomerRoles(String role) throws InterruptedException {

        if (!role.equals("Vendors")) {
            ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
        }
        WebElement ulCustomerRoles = ldriver.findElement(txtChildCustomerRoles);
        ulCustomerRoles.findElement(By.xpath("parent::*")).click();


        WebElement listItem;
        Thread.sleep(2000);

        if (role.equals("Administrators")) {
            listItem = ldriver.findElement(listItemAdmins);
        } else if (role.equals("Forum Moderators")) {
            listItem = ldriver.findElement(listItemModerators);
        } else if (role.equals("Guests")) {
            listItem = ldriver.findElement(listItemGuests);
        } else if (role.equals("Registered")) {
            listItem = ldriver.findElement(listItemRegistered);
        } else if (role.equals("Vendors")) {
            listItem = ldriver.findElement(listItemVendors);
        } else {
            listItem = ldriver.findElement(listItemGuests);
        }


        listItem.click();
    }

    public void setManagerOfVendor(String value) {
        Select drp = new Select(ldriver.findElement(drpOfVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender) {
        if (gender.equals("Male")) {
            ldriver.findElement(rdMaleGender).click();
        } else if (gender.equals("Female")) {
            ldriver.findElement(rdFemaleGender).click();
        } else {
            ldriver.findElement(rdMaleGender).click();
        }
    }

    public void setFirstName(String firstName) {
        ldriver.findElement(txtFirstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        ldriver.findElement(txtLastName).sendKeys(lastName);
    }

    public void setDateOfBirth(String dateOfBirth) {
        ldriver.findElement(txtDateOfBirth).sendKeys(dateOfBirth);
    }

    public void setCompanyName(String companyName) {
        ldriver.findElement(txtCompanyName).sendKeys(companyName);
    }

    public void setAdminComment(String adminComment) {
        ldriver.findElement(txtAdminComment).sendKeys(adminComment);
    }

    public void clickOnSave() {
        ldriver.findElement(btnSave).click();
    }
}
