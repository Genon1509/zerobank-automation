package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;



public class AccountStepDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    PayBillsPage payBillsPage = new PayBillsPage();

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        accountSummaryPage.navigateTo(link);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String page) {
        Assert.assertTrue("Page should be "+page, Driver.get().getTitle().contains(page));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String selected) {
        Select accountDropdown = new Select(accountActivityPage.accountDropdownElement);

        Assert.assertEquals("Expected option is not selected",selected,accountDropdown.getFirstSelectedOption().getText());
    }

    @And("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
        accountActivityPage.navigateTo(tab);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        accountActivityPage.fromDateInputBox.clear();
        accountActivityPage.toDateInputBox.clear();
        accountActivityPage.fromDateInputBox.sendKeys(fromDate);
        accountActivityPage.toDateInputBox.sendKeys(toDate);
    }

    @When("clicks Find")
    public void clicks_Find() {
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        fromDate = fromDate.replace("-","");
        toDate = toDate.replace("-","");
        int startDate = Integer.parseInt(fromDate);
        int endDate = Integer.parseInt(toDate);

        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDates);

        for (String date : elementsText) {
            date = date.replace("-","");
            int intDate = Integer.parseInt(date);
            Assert.assertTrue("Unwanted result date",intDate>=startDate && intDate<=endDate);
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
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
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDates);

        for (String elementsDate : elementsText) {
            Assert.assertFalse("Unwanted result date",elementsDate.contains(date));
        }

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        accountActivityPage.descriptionInputBox.clear();
        accountActivityPage.descriptionInputBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDescriptions);

        Assert.assertTrue("No result found",elementsText.size()>0);

        for (String text : elementsText) {
            Assert.assertTrue("Dose not contains expected string",text.contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDescriptions);

        for (String text : elementsText) {
            Assert.assertFalse("Contains unwanted string",text.contains(string));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDeposits);
        StringBuilder dummy = new StringBuilder("");

        for (String text : elementsText) {
            dummy.append(text);
        }
        Assert.assertTrue("No result for deposit",dummy.length()>0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultWithdrawal);
        StringBuilder dummy = new StringBuilder("");

        for (String text : elementsText) {
            dummy.append(text);
        }
        Assert.assertTrue("No result for withdrawal",dummy.length()>0);
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        Select typeDropdown = new Select(accountActivityPage.typeDropdownElement);
        typeDropdown.selectByVisibleText(string);
        BrowserUtils.waitFor(1);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultWithdrawal);
        StringBuilder dummy = new StringBuilder("");

        for (String text : elementsText) {
            dummy.append(text);
        }
        Assert.assertEquals("Result found for withdrawal", 0, dummy.length());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.findResultDeposits);
        StringBuilder dummy = new StringBuilder("");

        for (String text : elementsText) {
            dummy.append(text);
        }
        Assert.assertEquals("Result found for withdrawal", 0, dummy.length());
    }

    @When("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> information) {
        payBillsPage.payeeNameInputBox.sendKeys(information.get("Payee Name"));
        payBillsPage.payeeAddressInputBox.sendKeys(information.get("Payee Address"));
        payBillsPage.accountInputBox.sendKeys(information.get("Account"));
        payBillsPage.payeeDetailsInputBox.sendKeys(information.get("Payee details"));
        BrowserUtils.waitFor(1);
        payBillsPage.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        Assert.assertEquals("Message is not as expected",message,payBillsPage.alertMessage.getText());
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        Select currencyDropdown = new Select(payBillsPage.currencyDropdownElement);
        List<WebElement> options = currencyDropdown.getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(options);
        Assert.assertTrue("Not contains all the currencies",elementsText.containsAll(currencies));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.calculateCostsButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String expectedMessage="Please, ensure that you have filled all the required fields with valid values.";

        Assert.assertEquals("Message text is different than expected",expectedMessage,alert.getText());
        BrowserUtils.waitFor(1);
        alert.accept();
    }




}
