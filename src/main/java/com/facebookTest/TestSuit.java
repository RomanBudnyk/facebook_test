package com.facebookTest;

import com.facebookTest.pages.ProfilePage;
import com.facebookTest.pages.LoginPage;
import com.facebookTest.pages.MainPage;
import org.testng.annotations.Test;

import static com.facebookTest.data.TestData.*;

public class TestSuit extends HelpClass {
    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();
    private ProfilePage profilePage = new ProfilePage();

    //method to add company into Facebook profile, without additional fields
    @Test
    public void addWorkPlace() {
        loginPage.loginAs(EMAIL, PASSWORD, driver, wait);
        mainPage.disableNotif(driver, wait);
        mainPage.clickOnProfile(driver, wait);
        profilePage.clickOnAbout(driver, wait);
        profilePage.clickOnWorkAndStudy(driver, wait);
        profilePage.clickOnAddWork(driver, wait);
        profilePage.fillCompanyField(COMPANY_NAME, driver, wait, actions);
        profilePage.selectCompanyFromDropdown(driver, wait, actions);
        profilePage.clickSaveCompanyButton(driver, wait, actions);
    }
}


