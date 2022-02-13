package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityPage extends BaseAccountPage{

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdownElement;


}
