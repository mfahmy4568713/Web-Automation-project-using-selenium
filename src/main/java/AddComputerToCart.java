import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddComputerToCart {
    WebDriver driver;
    public AddComputerToCart(WebDriver driver){
        this.driver=driver;
    }
    public WebElement addComputer(){
        return  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
    }
    public WebElement selectProcessor(){
        return driver.findElement(By.cssSelector("#product_attribute_1"));
    }
    public WebElement selectRam(){
        return driver.findElement(By.xpath("//*[@id=\"product_attribute_2\"]"));
    }
    public WebElement chooseOS(){
        return driver.findElement(By.xpath("//*[@id=\"product_attribute_4_9\"]"));
    }
    public WebElement chooseHDD(){
        return driver.findElement(By.xpath("//*[@id=\"product_attribute_3_7\"]"));
    }
    public WebElement chooseSoftware(){
        return driver.findElement(By.xpath("//*[@id=\"product_attribute_5_10\"]"));
    }
    public WebElement addToCard(){
        return driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-1\"]"));
    }
    public WebElement goToCard(){
        return driver.findElement(By.xpath("//*[@id=\"topcartlink\"]"));
    }

    public WebElement actualResult(){
        return driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a"));
    }
    public By waitingUntil(){
        return By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a");
    }
}
