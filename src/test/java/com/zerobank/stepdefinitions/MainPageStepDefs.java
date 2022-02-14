package com.zerobank.stepdefinitions;

import com.zerobank.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MainPageStepDefs {

    @When("the user navigates to {string} tab")
    public void the_user_navigates_to_tab(String tab) {
        MainPage mainPage = new MainPage();
        mainPage.navigateToTab(tab);
    }

    @And("the user navigates to {string} module")
    public void the_user_navigates_to_module(String module) {
        MainPage mainPage = new MainPage();
        mainPage.navigateToModule(module);
    }

}
