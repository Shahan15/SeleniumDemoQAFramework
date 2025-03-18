package org.example.tests;

import org.example.utils.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataDrivenTest {

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        return new FileHandler().readJsonData();
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Testing login with: " + username + " / " + password);
        // Add logic for login validation here
    }
}

