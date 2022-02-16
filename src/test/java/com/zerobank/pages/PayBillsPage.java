package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BaseAccountPage{

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInputBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInputBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountInputBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInputBox;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "alert_content")
    public WebElement alertMessage;

}
