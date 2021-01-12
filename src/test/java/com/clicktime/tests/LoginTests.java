package com.clicktime.tests;

import com.clicktime.dataproviders.LoginDataProvider;
import com.clicktime.pageobjects.LoginPage;
import com.clicktime.utils.ConfigUtil;
import com.clicktime.validation.LoginTestValidation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests {

    @BeforeTest(groups = "regression", alwaysRun = true)
    public void beforeTest() throws IOException {
        ConfigUtil.init();
        System.setProperty("webdriver.chrome.driver", ConfigUtil.getChromeDriverPath());
    }

    @Test(groups = "regression", dataProviderClass = LoginDataProvider.class, dataProvider = "login-data-provider")
    public void LoginTestPositive(String userName, String email, String zipCode, String comments) throws IOException {

        //To run against multiple browsers you have to create this driver each browser from the base class
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get(ConfigUtil.getBaseUrl());

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(userName, email, zipCode, comments);

            LoginTestValidation loginTestValidation = new LoginTestValidation(driver);

            loginTestValidation.validateLogin(userName);
        } finally {
            driver.quit();
        }
    }

    @Test(groups = "regression", dataProviderClass = LoginDataProvider.class, dataProvider = "negative-login-data-provider")
    public void LoginTestNegative(String userName, String email, String zipCode, String comments) throws IOException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get(ConfigUtil.getBaseUrl());

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(userName, email, zipCode, comments);

            LoginTestValidation loginTestValidation = new LoginTestValidation(driver);

            loginTestValidation.validateNegativeLogin();
        } finally {
            driver.quit();
        }
    }

    @Test(groups = "regression", dataProviderClass = LoginDataProvider.class, dataProvider = "boundary-login-data-provider")
    public void LoginTestBoundaryTests(String userName, String email, String zipCode, String comments) throws IOException {

        WebDriver driver=new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get(ConfigUtil.getBaseUrl());

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(userName, email, zipCode, comments);

            LoginTestValidation loginTestValidation = new LoginTestValidation(driver);

            loginTestValidation.validateLogin(userName);
        } finally {
            driver.quit();
        }
    }
}
