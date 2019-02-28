package com.facebookTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private By profileButton = By.id("userNav");

    public void disableNotif(WebDriver driver, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.alertIsPresent()).dismiss();
            System.out.println("Alert dismissed successfully.");
        } catch (Exception e) {
            System.out.println("No alert was shown.");
        }
    }

    public void clickOnProfile(WebDriver driver, WebDriverWait wait) {
        driver.findElement(profileButton).click();
        System.out.println("Click on profile was successfully.");
    }
}
