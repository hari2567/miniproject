package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class searchpagetest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    HeaderSection headerSection;
    PopularPage popularPage;
    SearchPage searchPage;

    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerSection = new HeaderSection(driver);
        popularPage = new PopularPage(driver);
        searchPage = new SearchPage(driver);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }

    @Test(priority = 1)
    public void testsearch() {
        loginPage.loginToApplication("rahul", "rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement searchButton = driver.findElement(By.className("search-empty-button"));
        searchButton.click();
        int value = searchPage.searchFunction("Avatar");
        if (value >= 0) {
            System.out.println("movies are displayed");
        } else {
            System.out.println("not displayed");
        }
    }
}


