package org.example.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.example.utils.Base;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;


//we extend this class to access the methods in webDriverManager
public class HomePage extends Base {
    @FindBy(css = ".home-body > div > div:nth-child(6)") WebElement BookCard;
    @FindBy(id = "login") WebElement LoginButton;
    @FindBy(id = "userName") WebElement UsernameField;
    @FindBy(id = "password") WebElement PasswordField;
    @FindBy(id = "submit") WebElement LogoutButton;

    public HomePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        logger.info("Pagefactory has be instantiated");
    }

    public void ClickBookCard () {
        ScrollPage();
        BookCard.click();
        logger.info("Book card on Homepage has been clicked");
    }

    public void ScrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver; //this allows you to execute JS code
        js.executeScript("window.scrollBy(0,600);");
    }

    public boolean isLoginButtonPresent() {
        try {
            //2 second wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(LoginButton));
            logger.info("Waiting 5 seconds for LoginButton to appear");

            boolean isDisplayed = LoginButton.isDisplayed();
            logger.info("Login Button is present");
            return isDisplayed;
        } catch (Exception ex) {
            logger.error("Error occured,login button is not present {}",ex.getMessage());
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public void clickLoginButton() {
        LoginButton.click();
    }

    public void enterUsername (String username) {
        UsernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        PasswordField.sendKeys(password);
    }

    public void performLogin(String username, String password) {
        ClickBookCard();
        Base.logger.info("Navigating to Bookstore page");

        clickLoginButton();
        Base.logger.info("Clicked login button");

        enterUsername(username);
        Base.logger.info("Entered username: {}", username);

        enterPassword(password);
        Base.logger.info("Entered password");

        clickLoginButton();
        Base.logger.info("Submitted login information");

    }

    public void LogoutAndNavigateToHome() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(LogoutButton));
            logger.info("Waiting 3 seconds for logout button to appear");

            LogoutButton.click();
            logger.info("logged out");

            String targetUrl = "https://demoqa.com/"; // Replace with your desired URL
            driver.navigate().to(targetUrl);
            logger.info(STR."Navigated to the URL: \{targetUrl}");
        }catch (Exception ex) {
            logger.error("Error occurred,logout button is not present {}",ex.getMessage());
            System.out.println(ex.getMessage());
        }

    }

    public boolean isLoginSuccessfulCheck() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(LogoutButton));

            boolean isDisplayed = LogoutButton.isDisplayed();
            logger.info("Login was successful");
            return isDisplayed;
        } catch (NoSuchElementException ex) {
            logger.error("Login was unsuccessful: Logout button not found. {}", ex.getMessage());
            return false;
        } catch (TimeoutException ex) {
            logger.error("Login was unsuccessful: Logout button did not become visible in time. {}", ex.getMessage());
            return false;
        }
    }

}

/*PageFactory class is used to instantiate the
WebElements that are defined using @FindBy annotations.
How it works: Scanning for Annotations: When you call PageFactory.initElements(driver, this);,
Selenium scans the Page Object class (this) for fields annotated with '@FindBy.'
Locating Elements: For each field annotated with @FindBy, Selenium uses the provided 'driver' to
locate the corresponding web element on the web page.*/