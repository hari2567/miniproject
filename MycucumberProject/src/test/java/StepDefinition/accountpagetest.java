package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class accountpagetest {
    public WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    PopularPage popularPage;
    SearchPage searchPage;
    MovieDetails movieDetails;
    AccountPage accountPage;
    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");



        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSection=new HeaderSection(driver);
        popularPage=new PopularPage(driver);
        searchPage=new SearchPage(driver);
        movieDetails=new MovieDetails(driver);
        accountPage=new AccountPage(driver);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public  void testaccount(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        accountPage.avatarli().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        accountPage.wait.until(ExpectedConditions.visibilityOf(accountPage.accounthead()));
        accountPage.wait.until(ExpectedConditions.visibilityOf(accountPage.members()));
        accountPage.wait.until(ExpectedConditions.visibilityOf(accountPage.plancontai()));
        accountPage.wait.until(ExpectedConditions.elementToBeClickable(accountPage.logoutele()));
    }

}




