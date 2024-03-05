package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public int searchFunction(String movie){
        WebElement searchInput=driver.findElement(By.id("search"));
        searchInput.sendKeys(movie);
        List<WebElement> movieslist=driver.findElements(By.className("movie-icon-item"));
        return movieslist.size();
    }
}


