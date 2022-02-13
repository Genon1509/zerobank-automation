package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


public class AccountStepDefs {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickOnLink(link);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String page) {
        Assert.assertTrue("Page should be "+page, Driver.get().getTitle().contains(page));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String selected) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select accountDropdown = new Select(accountActivityPage.accountDropdownElement);

        Assert.assertEquals("Expected option is not selected",selected,accountDropdown.getFirstSelectedOption().getText());
    }


}
