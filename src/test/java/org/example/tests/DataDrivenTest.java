package org.example.tests;

import org.example.utils.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.example.pages.HomePage;
import org.example.utils.Base;

import java.io.IOException;

public class DataDrivenTest {

    HomePage homepage = new HomePage();

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        return new FileHandler().readJsonData();
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Testing login with: " + username + " / " + password);

//        if(!homepage.isLoginSuccessfulCheck()){
//            homepage.Logout();
//        }

        homepage.ClickBookCard();
        Base.logger.info("Navigating to Bookstore page");

        homepage.clickLoginButton();
        Base.logger.info("Clicked login Button");

        homepage.enterUsername(username);
        Base.logger.info("Enter username: {}", username);

        homepage.enterPassword(password);
        Base.logger.info("Entered password {}", password);

        homepage.clickLoginButton();
        Base.logger.info("Clicked Login info after entering user information");

//        Assert.assertTrue(homepage.isLoginSuccessfulCheck(), "Login was not successful for username: " + username);

        homepage.LogoutAndNavigateToHome();
        Base.logger.info("Logging out of {} account and navigating back to homepage ",username);
    }

    @AfterClass
    public void TearDown() {
        Base.quitDriver();
    }
}

