package com.zerobank.stepdefinitions;

import com.zerobank.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MainPageStepDefs {

    MainPage mainPage = new MainPage();

    @When("the user navigates to {string} tab")
    public void the_user_navigates_to_tab(String tab) {
        mainPage.navigateToTab(tab);
    }

    @And("the user navigates to {string} module")
    public void the_user_navigates_to_module(String module) {
        mainPage.navigateToModule(module);
    }

}
