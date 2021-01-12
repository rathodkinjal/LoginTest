package com.clicktime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath="//input[@id='fullName']")
    private WebElement userName;

    @FindBy(xpath="//input[@id='email']")
    private WebElement email;

    @FindBy(xpath="//input[@id='zipcode']")
    private WebElement zipCode;

    @FindBy(xpath="//textarea[@id='comments']")
    private WebElement comments;

    @FindBy(xpath="//input[@id='Submit1']")
    private WebElement submitButton;

    //p[contains(text(),'1234, your feedback has been submitted. Thanks for')]

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String email, String zipCode, String comments) {
        this.userName.sendKeys(userName);
        this.email.sendKeys(email);
        this.zipCode.sendKeys(zipCode);
        this.comments.sendKeys(comments);
        submitButton.submit();
    }
}
