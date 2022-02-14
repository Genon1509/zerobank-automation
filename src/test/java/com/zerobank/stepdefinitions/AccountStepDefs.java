package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class AccountStepDefs {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateTo(link);
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

    @And("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.navigateTo(tab);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDateInputBox.clear();
        accountActivityPage.toDateInputBox.clear();
        accountActivityPage.fromDateInputBox.sendKeys(fromDate);
        accountActivityPage.toDateInputBox.sendKeys(toDate);
    }

    @When("clicks Find")
    public void clicks_Find() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        fromDate = fromDate.replace("-","");
        toDate = toDate.replace("-","");
        int startDate = Integer.parseInt(fromDate);
        int endDate = Integer.parseInt(toDate);

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDates);

        for (String date : elementsText) {
            date = date.replace("-","");
            int intDate = Integer.parseInt(date);
            Assert.assertTrue("Unwanted result date",intDate>=startDate && intDate<=endDate);
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDates);

        List<Integer> datesAsInt = new ArrayList<>();
        for (String date : elementsText) {
            date = date.replace("-","");
            int intDate = Integer.parseInt(date);
            datesAsInt.add(intDate);
        }

        for (int i = 0; i < datesAsInt.size()-1; i++) {
             Assert.assertTrue("Order of the dates not as expected",datesAsInt.get(i)>datesAsInt.get(i+1));
        }

    }

    @Then("the results table should not contain transactions dated {string}")
    public void the_results_table_should_not_contain_transactions_dated(String date) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDates);

        Assert.assertFalse("Unwanted result date",elementsText.contains(date));

    }




}
