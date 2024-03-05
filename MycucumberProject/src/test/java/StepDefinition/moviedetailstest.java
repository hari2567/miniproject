package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class moviedetailstest {
    public WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    PopularPage popularPage;
    SearchPage searchPage;
    MovieDetails movieDetails;
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

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public void homepahetest(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        movieDetails.Hometext().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        movieDetails.imagelink().click();
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.detailscontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.movieheadi()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.moviedescrip()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.bottomcontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.footercontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.contactparag()));
        if(movieDetails.detailscontain().isDisplayed()&&movieDetails.movieheadi().isDisplayed()&&movieDetails.moviedescrip().isDisplayed()&&movieDetails.bottomcontain().isDisplayed()&&movieDetails.footercontain().isDisplayed()&&movieDetails.contactparag().isDisplayed()){
            System.out.println("homepahe movies are displayed");
        }else {
            System.out.println("not displayed");
        }

    }
    @Test(priority = 2)
    public void popularpage(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        movieDetails.popularli().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        movieDetails.imageuh().click();
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.detailscontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.movieheadi()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.moviedescrip()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.bottomcontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.footercontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.contactparag()));
        if(movieDetails.detailscontain().isDisplayed()&&movieDetails.movieheadi().isDisplayed()&&movieDetails.moviedescrip().isDisplayed()&&movieDetails.bottomcontain().isDisplayed()&&movieDetails.footercontain().isDisplayed()&&movieDetails.contactparag().isDisplayed()){
            System.out.println("populare movies are displayed");
        }else {
            System.out.println("not displayed");
        }

    }
}




