package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderSection;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class headersectiontest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");



        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSection=new HeaderSection(driver);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public void websitelogo(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(headerSection.logoNavigation().isDisplayed());
    }
    @Test(priority = 2)
    public void navigationpage(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(headerSection.homeNavigation().isDisplayed(),"not dis");
        Assert.assertTrue(headerSection.popularNavigation().isDisplayed(),"not dis");

    }
    @Test(priority = 3)
    public void testNavigationTOHomeAndPopularPage(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        headerSection.homeNavigation().click();
        String homeurl="https://qamoviesapp.ccbp.tech/";
        Assert.assertEquals(homeurl,driver.getCurrentUrl());
        headerSection.popularNavigation().click();
        String popularuel="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(popularuel,driver.getCurrentUrl());
    }
    @Test(priority = 4)
    public void testnavigationtoaccountpage(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        headerSection.avatarNaviagtion().click();
        String avatarurl="https://qamoviesapp.ccbp.tech/account";
        Assert.assertEquals(avatarurl,driver.getCurrentUrl());
    }

}
