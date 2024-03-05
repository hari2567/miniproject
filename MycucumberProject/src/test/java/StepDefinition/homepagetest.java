package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

    public class homepagetest {
        public WebDriver driver;
        LoginPage loginPage;
        HomePage homePage;
        @BeforeMethod
        @Test
        public void setup() {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://qamoviesapp.ccbp.tech");
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);

        }
        @Test(priority = 1)
        public void validinputs2(){
            loginPage.loginToApplication("rahul","rahul@2021");
            loginPage.submitLink2();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            String expectedtitle="React App";
            Assert.assertEquals(expectedtitle,driver.getTitle());
        }
        @Test(priority = 2)
        public void testHeadingtext(){
            loginPage.loginToApplication("rahul","rahul@2021");
            loginPage.submitLink2();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Assert.assertEquals("Home",homePage.homeText().getText());
            Assert.assertEquals("Popular",homePage.popularText().getText());

        }

        @Test(priority = 3)
        public void playbuttoncheck(){
            loginPage.loginToApplication("rahul","rahul@2021");
            loginPage.submitLink2();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Assert.assertTrue(homePage.button().isDisplayed(),"play button is not dis");
        }
        @Test(priority  =4)
        public void moviedisplay(){
            loginPage.loginToApplication("rahul","rahul@2021");
            loginPage.submitLink2();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Assert.assertTrue(homePage.trendingsec(),"not displayed");
            Assert.assertTrue(homePage.originalsec(),"not displayed");
        }
        @Test(priority = 5)
        public void contactsection(){
            loginPage.loginToApplication("rahul","rahul@2021");
            loginPage.submitLink2();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Assert.assertEquals("Contact Us",homePage.paragraphcontext().getText());
        }
        @AfterMethod
        public void teardown() {
            driver.quit();
        }


    }


