package web_pages;

import enums.RandomStrings;
import enums.Url;
import enums.Users;
import org.apache.commons.lang3.EnumUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.DriverFactory;
import utils.RandomString;
import utils.Wait;


/**
 * Implemented with Page Object and Page factory model this class consist of web elements and
 * methods for logging page of Screenployee
 *
 * @author Zoran Zivanovic
 * @version 1.0
 * @since 25.01.20 updated N/A
 *
 *
 */

public class LoginPage extends LoadableComponent<LoginPage> {
    WebDriver driver = DriverFactory.getDriver();
    Wait wait = new Wait();
   // SoftAssert softAssert = new SoftAssert();
    private String title = "test";


    // Page factory
    // ######################################################################################################################################
    @FindBy(xpath = "//h3[contains(text(),'Screenployee')]")
    private WebElement headScreenployee;
    @FindBy(xpath = "//input[@placeholder='email']")
    private WebElement txtFldEmail;
    @FindBy(xpath = "//input[contains(@placeholder,'username')]")
    private WebElement txtFldUserName;
    @FindBy(xpath = "//input[@placeholder='password']")
    private WebElement txtFldPassword;
    @FindBy(xpath = "//input[@placeholder='username / email']")
    private WebElement txtFldUserEmail;
    @FindBy(xpath = "//button[contains(@class,'sign')]")
    private WebElement btnSignIn;
    @FindBy(xpath = "//div[@class='signup-button']")
    private WebElement btnSignInUp;




    // Ending page factory
    // ######################################################################################################################################

    public LoginPage() {

        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void ishomepageDisplayed() {

        wait.forElementEnabled(headScreenployee);
        btnSignIn.isEnabled();

    }

    // used for selenium loadable component
    @Override
    protected void isLoaded() throws Error {

       Assert.assertTrue("Login page not loaded", driver.getTitle().equals("fff"));

    }
    @Override
    protected void load() {
        // TODO

    }
    public void getPage(String url){
        if(url.equalsIgnoreCase("SCREENPLOYEELOGIN")){
            getLoginPage(url);
            //Assert.assertEquals(btnSignIn.getText(),"Sign In","This is not Sign in page please check the value of the page");
        }
        else if (url.equalsIgnoreCase("SCREENPLOYEEREGISTER")){
            getRegisterPage();
            Assert.assertEquals("This is not Sign up page please check the value of the page",btnSignIn.getText(),"Sign Up");

        }
        else {
            System.out.println("Name of the page is not properly define");
        }
    }
    private void getLoginPage(String url){
        DriverFactory.driver.get(Url.valueOf(url.toUpperCase()).getUrl());
    }
    private void getRegisterPage(){
        getLoginPage("SCREENPLOYEELOGIN");
        btnSignInUp.click();
    }

    /**
     * use to select environment QA,DEV or PROD and insert parameters (user name and password)
     *
     * @param userName
     * @param email
     */


    public void registerOrLogin(String userName, String email){
        System.out.println(btnSignIn.getText());
        //If test find that is a sign in page it will send parameters without email for sign in
        if (btnSignIn.getText().trim().equalsIgnoreCase("sign in")) {
            signInUp(userName);
        }
        //If auto test go to else it will be sign up page and it will send parameters with email for sign up
        else {

            signInUp(userName, email);
        }
    }



    /**
     * Sending user name and pass to text field in login page
     * @param userName
     *
     */
    private void signInUp(String userName)  {
        txtFldUserName.sendKeys(Users.valueOf(userName.toUpperCase()).getUserParams());
        txtFldPassword.sendKeys(Users.valueOf(userName.toUpperCase() + "pass".toUpperCase()).getUserParams());
    }
    private void signInUp(String userName,String email)  {
        if(userName.contains("RANDOM")) {
            RandomString userRandomName = new RandomString(userName,5);
            txtFldUserName.sendKeys(userRandomName.getRandomString());
            txtFldEmail.sendKeys(userRandomName.getRandomString() + email);
            txtFldPassword.sendKeys(EnumUtils.getEnum(Users.class,"VALIDREGISTERUSERPASS").toString());
        }
        else{
            txtFldUserName.sendKeys(Users.valueOf(userName.toUpperCase()).getUserParams());
            txtFldPassword.sendKeys(Users.valueOf(userName.toUpperCase() + "pass".toUpperCase()).getUserParams());
            txtFldEmail.sendKeys(email);

        }



    }

    public void clickOnSignUp(){
        btnSignIn.click();
    }
    public void checkErrorMessage(String errorMessage){
        WebElement error = driver.findElement(By.xpath("//p[contains(text()," +"'"+ errorMessage+"'" +")]"));
        wait.forTextPresentInElement(error,errorMessage);
       Assert.assertEquals("Error message is not the same", error.getText(), errorMessage);
    }



}