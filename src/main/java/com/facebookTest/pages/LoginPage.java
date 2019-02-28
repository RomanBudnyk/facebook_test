package com.facebookTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class LoginPage {
    private By login = By.id("email");
    private By password = By.id("pass");
    private By enter = By.id("loginbutton");

    private void typeLogin(String name, WebDriver driver) {
        driver.findElement(login).sendKeys(name);
        System.out.println("Login: " + name);
    }

    private void typePassword(String pass, WebDriver driver) {
        driver.findElement(password).sendKeys(pass);
        System.out.println("Password: " + pass);
    }

    private void pressEnter(WebDriver driver) {
        driver.findElement(enter).submit();
        System.out.println("Enter button pressed successfully.");
    }

    public void loginAs(String login, String pass, WebDriver driver, WebDriverWait wait) {
        driver.get("https://www.facebook.com/");
        typeLogin(login, driver);
        typePassword(pass, driver);
        pressEnter(driver);
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sideNav"))).isDisplayed());
        System.out.println("Login was succeed.");
    }

}
