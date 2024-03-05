package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogoutFunctionalitysteps {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Given("I am on the logout page")
    public void iAmOnLoginpageforlogout() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }
    @When("I enter valid username and password")
    public  void iClickontheuserandpaddwordforlogout(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }
    @And("I click on the login button")
    public void iClickOnTheLoginButtonforlogout(){
        driver.findElement(By.className("login-button")).click();
    }
    @When("I click on account page")
    public void iclickonaccountpage(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar-button")));
        element.click();
    }
    @And("I click on logout button")
    public void iclickonlogoutbutton(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement logoutbutton = driver.findElement(By.className("logout-button"));
        logoutbutton.click();
    }




    @Then("I should be redirected to the home page logout")
    public void iShouldredirectedtohomepageforlogout(){
        String expectedurl="https://qamovies.ccbp.tech/login";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedurl,"url do not match");
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
