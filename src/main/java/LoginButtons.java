import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginButtons {
    WebDriver driver ;
    public LoginButtons (WebDriver driver){
        this.driver=driver;

    }
    public WebElement loginButtonEle(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }
    public WebElement writeEmailEle(){
        return driver.findElement(By.xpath("//*[@id=\"Email\"]"));
    }
    public WebElement writePasswordEle(){
        return  driver.findElement(By.xpath("//*[@id=\"Password\"]"));
    }
    public WebElement okButtonEle(){
        return  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
    }
    public WebElement actualResult(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }

}

