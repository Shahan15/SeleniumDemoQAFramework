package org.example.tests;

import utils.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Base;

import java.io.IOException;

public class DataDrivenTest {

    HomePage homepage = new HomePage();

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        return new FileHandler().readJsonData();
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        Base.logger.info("Testing login with: {} / {}", username, password);
        homepage.performLogin(username, password);

        homepage.LogoutAndNavigateToHome();
        Base.logger.info("Logged out from {} account and navigated back to homepage", username);
    }

    @AfterClass
    public void TearDown() {
        Base.quitDriver();
    }
}

