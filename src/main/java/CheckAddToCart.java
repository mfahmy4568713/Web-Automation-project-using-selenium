import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckAddToCart {
    WebDriver driver;
    public CheckAddToCart(WebDriver driver){
        this.driver=driver;
    }
    public By waitElement(){return By.cssSelector("td input[type=\"text\"]:nth-child(2)");}
    public WebElement numberLaptopItems(){return  driver.findElement(By.cssSelector("td input[type=\"text\"]:nth-child(2)"));}
    public WebElement actualResult(){return driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td[6]/span"));}
}

