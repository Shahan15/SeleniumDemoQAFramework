package stepdefinitions;


import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.utils.Base;
import org.example.utils.ExtentReportHelper;
import org.example.utils.FileHandler;
import org.testng.Assert;

import java.io.IOException;



public class LoginSteps {

    private HomePage homepage;

    @Before
    public void setUp() {
        homepage = new HomePage();
        Base.logger.info("Webdriver and Homepage initialised");
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        homepage.ClickBookCard();

        homepage.clickLoginButton();
        Base.logger.info("@GIVEN: Clicked login button to navigate to login page");
        Assert.assertTrue(homepage.isLoginButtonPresent(), "You are on login page");
    }

    @When("they enter valid username")
    public void theyEnterValidCredentials() throws IOException {
        String username = FileHandler.getFirstUserFromJson().username;

        homepage.enterUsername(username);
        Base.logger.info("@WHEN: entered username {}", username);
        ExtentReportHelper.logStep(Status.INFO, "Entering username: " + username);
    }


    @And("they enter valid password")
    public void theyEnterValidPassword() throws IOException {

        String password = FileHandler.getFirstUserPasswordFromJson().password;

        homepage.enterPassword(password);
        Base.logger.info("@AND: entered password {}", password);

        ExtentReportHelper.logStep(Status.INFO, "Entering password: " + password);
    }


    @And("they click on the Login Button")
    public void theyClickOnTheLoginButton() {
        homepage.clickLoginButton();
        Base.logger.info("@AND: clicked on login button after entering user and pass");
    }

    @Then("they should be redirected to the dashboard")
    public void theyShouldBeRedirectedToTheDashboard() {

        Assert.assertTrue(homepage.isLoginSuccessfulCheck());
        Base.logger.info("@THEN: redirected to dashboard,Login was successful");

        ExtentReportHelper.logStep(Status.PASS, "User successfully redirected to the dashboard.");

    }

}


//so here we write the logic of each step from the feature file
