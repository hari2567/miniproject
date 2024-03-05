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
import pages.PopularPage;

import java.time.Duration;

public class popularpagetest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    PopularPage popularPage;
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

    }

    @Test(priority = 1)
    public void popularsearch(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        popularPage.popularnavi().click();
        popularPage.imagelin().click();
        popularPage.popularnavi().click();
        String expectedurlp="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(expectedurlp,driver.getCurrentUrl());
    }
    @Test(priority = 2)
    public void moviessearch(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int value= popularPage.checkpopularmovies();
        if(value==30){
            System.out.println("movies are displayed");
        }else{
            System.out.println("not displayed");
        }


    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}




