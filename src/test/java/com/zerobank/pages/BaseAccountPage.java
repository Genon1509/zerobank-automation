package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;

public class BaseAccountPage extends BasePage{

    public void navigateTo(String tab){
        Driver.get().findElement(By.linkText(tab)).click();
    }


}
