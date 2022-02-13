package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;

public class AccountSummaryPage extends BaseAccountPage{

    public void clickOnLink(String link){
        Driver.get().findElement(By.linkText(link)).click();
    }

}
