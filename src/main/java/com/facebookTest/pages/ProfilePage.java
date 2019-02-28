package com.facebookTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ProfilePage {
    private By aboutTab = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div/div[2]/div[2]/ul/li[2]/a");
    private By workTab = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/div[2]/div/ul/li/div/div[1]/div/div/ul/li[2]/a/span[1]");
    private By addWork = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/div[2]/div/ul/li/div/div[2]/div/div/div/div[1]/ul/li/a/div/div/div[2]/div/div[2]/div/span[1]");
    private By companyField = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/div[2]/div/ul/li/div/div[2]/div/div/div/div[1]/ul/li[1]/div/form/ul/li[2]/div/div[1]/label");
    private By saveCompany = By.name("__submit__");

    public void clickOnAbout(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutTab)).click();
        System.out.println("About tab pressed.");
    }

    public void clickOnWorkAndStudy(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(workTab)).click();
        System.out.println("Work and study section pressed.");
    }

    public void clickOnAddWork(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addWork)).click();
        System.out.println("Add work button pressed.");
    }

    public ProfilePage fillCompanyField(String company, WebDriver driver, WebDriverWait wait, Actions actions) {
        actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(companyField))).sendKeys(company).pause(1000).build().perform();
        System.out.println("Company field filled up.");
        return this;
    }


    public void selectCompanyFromDropdown(WebDriver driver, WebDriverWait wait, Actions actions) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        actions.sendKeys(Keys.DOWN, Keys.RETURN).build().perform();
        System.out.println("Company selected.");
    }

    public void clickSaveCompanyButton(WebDriver driver, WebDriverWait wait, Actions actions) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveCompany)).click();
        assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(saveCompany)));
        System.out.println("Company saved successfully.");
    }

}
