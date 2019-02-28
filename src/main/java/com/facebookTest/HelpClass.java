package com.facebookTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class HelpClass {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    //Use this for test in Google Chrome
//    @BeforeTest
    public void chromeRun() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    //Use this for cross-browser testing. Run cross-browser-test.xml for this.
    @BeforeTest
    @Parameters({"browser"})
    public void start(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());
            options.addPreference("dom.webnotifications.enabled", false);
            driver = new FirefoxDriver(options);
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, 7, 100);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, 7, 100);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, 7, 100);
            driver.manage().window().maximize();
        } else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
