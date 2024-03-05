package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage {

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/a/div/img")
    List<WebElement> trendingsection;
    @FindBy (xpath = "/html/body/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/a/div/img")
    List<WebElement>originalsection;
    @FindBy(xpath = "//a[text()='Home']")
    WebElement homeheading;
    @FindBy(xpath = "//a[text()='Popular']")
    WebElement popularheading;

    @FindBy (className = "home-movie-play-button")
    WebElement layButton;
    @FindBy(className = "contact-us-paragraph")
    WebElement paragraph;




    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public  WebElement button(){
        return  layButton;
    }
    public WebElement paragraphcontext(){
        return  paragraph;
    }
    public WebElement homeText(){
        return homeheading;
    }
    public WebElement popularText(){
        return popularheading;
    }
    public boolean trendingsec(){
        return   trendingsection.size()>0 && originalsection.size()>0;
    }
    public boolean originalsec(){
        return  trendingsection.size()>0 && originalsection.size()>0;
    }
}


