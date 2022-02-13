package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;

public class MainPage extends BasePage{


    public void navigateToTab(String tab){
        String path = "//strong[text()='"+tab+"']";
        Driver.get().findElement(By.xpath(path)).click();
    }

    public void navigateToModule(String module){
        String path = "//*[text()='"+module+"']";
        Driver.get().findElement(By.xpath(path)).click();
    }


}
