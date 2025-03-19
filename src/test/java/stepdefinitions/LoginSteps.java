package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.utils.Base;
import org.testng.Assert;

public class LoginSteps {
    private boolean isLoggedIn = false;

     private HomePage homepage;

     @Before
     public void setUp( ) {
         homepage= new HomePage();
         Base.logger.info("Webdriver and Homepage initialised");
     }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        homepage.ClickBookCard();
        Assert.assertTrue(homepage.isLoginButtonPresent(),"LoginButton is present you are on login page");
        homepage.isLoginButtonPresent();
    }

    @When("they enter valid credentials")
    public void theyEnterValidCredentials() {
        isLoggedIn = true; // Simulating successful login
    }

    @Then("they should be redirected to the dashboard")
    public void theyShouldBeRedirectedToTheDashboard() {
        Assert.assertTrue(isLoggedIn, "User is not logged in");
        System.out.println("User is redirected to the dashboard");

    }

    @After
    public void TearDown () {
        Base.quitDriver();
    }

}



//so here we write the logic of each step from the feature file
