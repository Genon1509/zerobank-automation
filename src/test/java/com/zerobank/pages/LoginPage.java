package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement loginInputBox;

    @FindBy(id = "user_password")
    public WebElement passwordInputBox;

    @FindBy(name = "submit")
    public WebElement signInButton;


    public void logIn(){
        MainPage mainPage = new MainPage();
        mainPage.signInButton.click();
        loginInputBox.sendKeys(ConfigurationReader.get("username"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        signInButton.click();
        Driver.get().navigate().back();
    }


}
