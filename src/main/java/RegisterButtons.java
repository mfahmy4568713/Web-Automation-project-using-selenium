import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterButtons {
    WebDriver driver;
    public RegisterButtons(WebDriver driver){
        this.driver=driver;
    }
    public WebElement registerButtonEli() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }

    public WebElement genderButtonEli() {
        return driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
    }

    public WebElement firstNameEli() {
        return driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
    }

    public WebElement lastNameEli() {
        return driver.findElement(By.xpath("//*[@id=\"LastName\"]"));
    }

    public WebElement selectDayEli() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]"));
    }

    public WebElement selectMonthEli() {
        return driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body > form > div:nth-child(1) > div.form-fields > div.inputs.date-of-birth > div > select:nth-child(2)"));
    }

    public WebElement selectYearEli() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]"));
    }

    public WebElement writeEmailEli() {
        return driver.findElement(By.xpath("//*[@id=\"Email\"]"));
    }
    public WebElement writeCompanyEli(){
        return driver.findElement(By.xpath("//*[@id=\"Company\"]"));
    }
    public WebElement writePasswordEli(){
        return driver.findElement(By.xpath("//*[@id=\"Password\"]"));
    }
    public WebElement writeConfirmPasswordEli(){
        return driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]"));
    }
    public WebElement registerButtonBEli(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"register-button\"]"));
    }
    public WebElement actualResultEli(WebDriver driver){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li"));
    }
}
