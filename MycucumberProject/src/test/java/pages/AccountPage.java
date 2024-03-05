package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    @FindBy(className = "avatar-button")
    WebElement avatarlink;
    @FindBy(className = "account-heading")
    WebElement accountheading;
    @FindBy(className = "membership-container")
    WebElement membership;
    @FindBy(className = "plan-container")
    WebElement plancontainer;
    @FindBy(className ="logout-button")
    WebElement logoutelent;
    WebDriver driver;
    public  WebDriverWait wait;
    public AccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public WebElement avatarli(){
        return avatarlink;
    }
    public WebElement accounthead(){
        return  accountheading;
    }
    public WebElement members (){
        return membership ;
    }
    public WebElement plancontai(){
        return plancontainer ;
    }
    public WebElement logoutele(){
        return logoutelent;
    }
}


