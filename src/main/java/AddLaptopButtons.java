import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddLaptopButtons {
    WebDriver driver;
    public AddLaptopButtons(WebDriver driver) {
    this.driver=driver;
    }
    public WebElement chooseLaptop (){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]"));
    }
    public WebElement addToCardButton (){
        return driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-4\"]"));
    }
    public WebElement toCardButton (){
        return driver.findElement(By.xpath("//*[@id=\"topcartlink\"]"));
    }
    public WebElement actualResult (){
        return driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a"));
    }
    public By byCard (){
        return By.xpath("//*[@id=\"add-to-cart-button-4\"]");
    }

}
