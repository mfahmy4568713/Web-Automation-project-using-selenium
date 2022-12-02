import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchButtons {
    WebDriver driver ;
    public SearchButtons(WebDriver driver){
        this.driver=driver;
    }
    public WebElement searchFieldEle(){
        return driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
    }
    public WebElement searchButtonEle() {
        return driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
    }
    public WebElement actualResultEle1(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a"));
    }
    public WebElement actualResultEle2(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a"));
    }


}
