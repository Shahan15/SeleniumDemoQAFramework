package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.example.utils.Base;
import org.openqa.selenium.support.ui.WebDriverWait;


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
        js.executeScript("arguments[0].scrollIntoView();", BookCard);
    }

    public boolean isLoginButtonPresent() {
        try {
            //2 second wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(LoginButton));
            logger.info("Waiting 2 seconds for LoginButton to appear");

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

    public void LogoutAndNavigateToHome() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(LogoutButton));
            logger.info("Waiting 3 seconds for logout button to appear");

            LogoutButton.click();
            logger.info("logged out");

            String targetUrl = "https://demoqa.com/"; // Replace with your desired URL
            driver.navigate().to(targetUrl);
            logger.info("Navigated to the URL: " + targetUrl);
        }catch (Exception ex) {
            logger.error("Error occurred,logout button is not present {}",ex.getMessage());
            System.out.println(ex.getMessage());
        }

    }

    public boolean isLoginSuccessfulCheck () {
        try {
            boolean isDisplayed = LogoutButton.isDisplayed();
            logger.info("Login was successful");
            return isDisplayed;
        } catch (Exception ex) {
            logger.error("Login was unsuccessful {}",ex.getMessage());
            System.out.println(ex.getMessage());
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