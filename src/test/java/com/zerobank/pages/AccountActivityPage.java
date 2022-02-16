package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BaseAccountPage{

    @FindBy(linkText = "Show Transactions")
    public WebElement showTransactionsTab;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdownElement;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInputBox;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInputBox;

    @FindBy(css = "button[type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> findResultDates;

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[2]")
    public List<WebElement> findResultDescriptions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement> findResultDeposits;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement> findResultWithdrawal;

    @FindBy(id = "aa_type")
    public WebElement typeDropdownElement;


}
