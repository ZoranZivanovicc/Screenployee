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
    private String userName;
    private String eMail;
    private String birthday;

    public EmployeesPage() {

        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
    // Page factory
    // ######################################################################################################################################
    @FindBy(xpath = "//button[contains(text(),'Create new employee')]")
    private WebElement btnCreateNewEmploye;
    @FindBy(xpath = "//h3[contains(text(),'All Employees')]")
    private WebElement headAllEmployees;
    @FindBy(xpath = "//div[@class='single-employee-holder']//div[2]//input[1]")
    private WebElement txtFieldName;
    @FindBy(xpath = "//div[3]//input[1]")
    private WebElement txtFieldEmail;
    @FindBy(xpath = "//div[4]//input[1]")
    private WebElement txtFieldBirthday;
    @FindBy(xpath = "//div[@class='all-employees-holder']/div[1]")
    private WebElement frameEmployee;
    @FindBy(xpath = "//div[@class='employees-screen']//div[1]//div[1]//img[1]")
    private WebElement icoSmiley;
    @FindBy(xpath = "//button[contains(text(),'Add Employee')]")
    private WebElement btnAddEmployee;
    @FindBy(xpath = "//button[contains(text(),'Delete employee')]")
    private WebElement btnDeleteEmployee;
    @FindBy(xpath = "//button[contains(text(),'Sign Out')]")
    private WebElement btnSignOut;


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

        wait.forTextPresentInElement(headAllEmployees,"All Employees");
        String url = driver.getCurrentUrl();
        Assert.assertEquals("Url doesn't mach with employees page", Url.valueOf(page.toUpperCase()).getUrl(),url);
    }
    public void createNewEmployee(){
        btnCreateNewEmploye.click();
    }
    public void addValueForNewEmployee(String userName, String eMail,String birthday){
        this.userName = userName;
        this.eMail = eMail;
        this.birthday = birthday;
        txtFieldName.sendKeys(userName);
        txtFieldEmail.sendKeys(eMail);
        txtFieldBirthday.sendKeys(birthday);
        btnAddEmployee.click();

    }
    public void openEmployeeFrame(){
        wait.forElementEnabled(icoSmiley);
        frameEmployee.click();
    }
    public void checkEmployeeValue(){
        Assert.assertEquals("Username is not the same", userName,txtFieldName.getAttribute("placeholder"));
        Assert.assertEquals("Username is not the same", eMail,txtFieldEmail.getAttribute("placeholder"));
        Assert.assertEquals("Username is not the same", birthday,txtFieldBirthday.getAttribute("placeholder"));
    }
    public void deleteEmploye(){
        txtFieldEmail.click();
        wait.forElementEnabled(btnDeleteEmployee);
        btnDeleteEmployee.click();
        try {
            wait.waitForNumberOfSeconds(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void loggedOut(){
        btnSignOut.click();
    }

}
