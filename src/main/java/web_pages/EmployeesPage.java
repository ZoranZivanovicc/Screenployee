package web_pages;

import enums.Url;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.DriverFactory;
import utils.Wait;

public class EmployeesPage  extends LoadableComponent<EmployeesPage> {
    final String urlEmployeesPage = "https://screenployee-allthingstalk.firebaseapp.com/employees";

    WebDriver driver = DriverFactory.getDriver();
    Wait wait = new Wait();

    public EmployeesPage() {

        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
    // Page factory
    // ######################################################################################################################################
    @FindBy(xpath = "//button[contains(text(),'Create new employee')]")
    private WebElement btnCreateNewEmploye;
    @FindBy(xpath = "//h3[contains(text(),'All Employees')]")
    private WebElement headAllEmployees;


    // Ending page factory
    // ######################################################################################################################################

    public void isEmployeesPage() {

        wait.forElementEnabled(btnCreateNewEmploye);


    }
    @Override
    protected void isLoaded() throws Error {

        Assert.assertTrue("Login page not loaded", driver.getTitle().equals("lllll"));

    }
    @Override
    protected void load() {
        // TODO

    }
    public void employeePageIsVisible(String page){
        String url = driver.getCurrentUrl();
        wait.forTextPresentInElement(headAllEmployees,"All Employees");
        Assert.assertEquals("Url doesn't mach with employees page", Url.valueOf(page.toUpperCase()).getUrl(),url);
    }
}
