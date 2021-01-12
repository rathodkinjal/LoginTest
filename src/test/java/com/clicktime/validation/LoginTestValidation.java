package com.clicktime.validation;

import com.clicktime.utils.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginTestValidation {

    private WebDriver driver;

    public LoginTestValidation(WebDriver driver) {
        this.driver = driver;
    }

    public void validateLogin(String userName) throws IOException {
        String actualUrl = "https://login.clicktime.com/qa/?sub=123";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        WebElement submitMessage = driver.findElement(By.xpath("//*[@id='content']/p"));
        Assert.assertEquals(submitMessage.getText(), userName + ConfigUtil.getSuccessMessage());
    }

    public void validateNegativeLogin() throws IOException {
        WebElement errorMessage = driver.findElement(By.xpath("//span[@class='oops']"));
        Assert.assertEquals(errorMessage.getText(), ConfigUtil.getErrorMessage());
    }
}
