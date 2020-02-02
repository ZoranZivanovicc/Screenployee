package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import web_pages.EmployeesPage;
import web_pages.LoginPage;

public class MyStepdefs {
    LoginPage loginPage = new LoginPage();
    EmployeesPage employeesPage = new EmployeesPage();
    @Given("I'm on tmOne page on {string} for {string} market")
    public void iMOnTmOnePageOnForMarket(String arg0, String arg1) {
    }

    @When("I select {string} language")
    public void iSelectLanguage(String arg0) {

    }

    @Given("The system shows {string} page")
    public void theSystemShowsPage(String url) {
        loginPage.getPage(url);

    }



    @When("I choose to {string} with a {string} and {string}")
    public void iChooseToRegisterWithAAndEmail(String typeOfAction, String userName, String email) {
        loginPage.registerOrLogin(userName,email);
        loginPage.clickOnSignUp();


    }




    @Then("I {string} and the system shows {string}")
    public void iRegisteredAndTheSystemShows(String typeOfAction, String webPage) {
        employeesPage.employeePageIsVisible(webPage);

    }

    @When("I choose to register with a {string} and {string}")
    public void iChooseToRegisterWithAAnd(String userName, String email) {
        loginPage.registerOrLogin(userName,email);
        loginPage.clickOnSignUp();
    }

    @Then("{string} displayed")
    public void displayed(String errorMessage) {
        loginPage.checkErrorMessage(errorMessage);

    }


    @When("I choose to {string} with a user with {string} and {string}")
    public void iChooseToWithAUserWithAnd(String typeOfAction, String randomStringUser, String randomEmail) {
        loginPage.registerOrLogin(randomStringUser,randomEmail);
        loginPage.clickOnSignUp();

    }




    @And("I create a new employee with {string},{string}, {string} data value")
    public void iCreateANewEmployeeWithDataValue(String userName, String eMail, String birthday) {
        employeesPage.createNewEmployee();
        employeesPage.addValueForNewEmployee(userName,eMail,birthday);

    }

    @Then("I can see employee with a listed value")
    public void iCanSeeEmployeeWithAListedValue() {
        employeesPage.openEmployeeFrame();
        employeesPage.checkEmployeeValue();
    }

    @When("I delete employye")
    public void iDeleteEmployye() {
        employeesPage.deleteEmploye();
    }



    @Then("I logged out")
    public void iLoggedOut() {
        employeesPage.loggedOut();
    }
}
