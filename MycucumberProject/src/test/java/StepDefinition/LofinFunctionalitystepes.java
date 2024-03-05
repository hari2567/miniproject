package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LofinFunctionalitystepes {
     WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Given ("I am on the login page")
    public void iAmOnTheLoginPage1() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }
    @When("I check imagelogo is displayed")
    public void icheckimagelogoisdisplayed(){
        driver.findElement(By.className("login-website-logo"));
    }
    @And("I check heading element is displayed")
    public  void icheckheadingelementisdisplayed(){
        driver.findElement(By.className("sign-in-heading"));
    }
    @And("I check username element is dispalyed")
    public void icheckusernameelemetisdisplayed(){
        driver.findElement(By.xpath("//label[text()='USERNAME']"));
    }

    @And("I check password element is displayed")
    public void icheckpasswordelementisdisplayed(){
        driver.findElement(By.xpath("//label[text()='PASSWORD']"));
    }
    @Then ("I check button is dispalyed")
    public void icheckbuttonisdispalyed(){
        driver.findElement(By.className("login-button"));

    }


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }
    @When("I enter valid username and password")
    public  void iClickOnTheLoginPassword(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }
    @And("I click on the login button")
    public void iClickOnTheLoginButton(){
        driver.findElement(By.className("login-button")).click();
    }
    @Then("I should be redirected to the home page")
    public void iShouldBeReDirectedToHomepage(){
        String expectedurl="http://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedurl,"url do not match");
    }
    @After
    public void teardown(){
        driver.quit();
    }
9
}
