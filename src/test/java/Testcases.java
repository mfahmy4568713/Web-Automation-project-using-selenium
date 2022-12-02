import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.output.AppendableOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import java.util.Set;

public class Testcases {
    WebDriver driver;
    RegisterButtons registerButtons ;
    AddLaptopButtons addLaptopButtons ;
    LoginButtons loginButtons;
    SearchButtons searchButtons ;
    AddComputerToCart addComputerToCart;
    CheckAddToCart checkAddToCart;
    CheckSocialMedia checkSocialMedia;


    @BeforeClass
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
         loginButtons =new LoginButtons(driver);
         addLaptopButtons =new AddLaptopButtons(driver);
        registerButtons =new RegisterButtons(driver);
        searchButtons =new SearchButtons(driver);
        addComputerToCart=new AddComputerToCart(driver);
        checkAddToCart=new CheckAddToCart(driver);
        checkSocialMedia =new CheckSocialMedia(driver);
        Thread.sleep(3000);
    }

    @Test(priority = 1,dataProviderClass = ReadRegisterData.class,dataProvider = "data Register")
    public void testcase1_register(String firstName ,String lastname,String day,int m,String y,String email,String c,String pass,String confirm) throws InterruptedException {

        registerButtons.registerButtonEli().click();
        registerButtons.genderButtonEli().click();
        registerButtons.firstNameEli().sendKeys(firstName);
        registerButtons.lastNameEli().sendKeys(lastname);
        Select days = new Select(registerButtons.selectDayEli());
        days.selectByValue(day);
        Select month = new Select(registerButtons.selectMonthEli());
        month.selectByIndex(m);
        Select year = new Select(registerButtons.selectYearEli());
        year.selectByValue(y);
        //registerButtons.writeEmailEli().sendKeys("yiyic12812@corylan.com");
        registerButtons.writeEmailEli().sendKeys(email);
        registerButtons.writeCompanyEli().sendKeys(c);
        registerButtons.writePasswordEli().sendKeys(pass);
        registerButtons.writeConfirmPasswordEli().sendKeys(confirm);
        registerButtons.registerButtonBEli(driver).click();
        String expectedResult = null, actualResult;
        String actual1 = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
        Thread.sleep(3000);
        if (email != "mohamedalifahmy2021@gmail.com") {
            expectedResult = "Wrong email";
            actualResult = driver.findElement(By.xpath("//*[@id=\"Email-error\"]")).getText();
            Assert.assertTrue(actualResult.contains(expectedResult),"Wrong email");

        } else if (firstName=="") {
            expectedResult = "First name is required.";
            actualResult = driver.findElement(By.xpath("//*[@id=\"FirstName-error\"]")).getText();
            Assert.assertTrue(actualResult.contains(expectedResult),"firstname is empty");
        }
            else if (lastname=="") {
                expectedResult = "Last name is required.";
                actualResult = driver.findElement(By.xpath("//*[@id=\"LastName-error\"]")).getText();
                Assert.assertTrue(actualResult.contains(expectedResult),"lastname is empty");
            }
                 else if (lastname=="") {
                expectedResult = "Last name is required.";
                actualResult = driver.findElement(By.xpath("//*[@id=\"LastName-error\"]")).getText();
                Assert.assertTrue(actualResult.contains(expectedResult));
        } else {
            if (driver.getCurrentUrl().equalsIgnoreCase(actual1)) {
                expectedResult="Your registration completed";
                actualResult=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getText();
                Assert.assertTrue(actualResult.contains(expectedResult));

            } else {
                expectedResult = "The specified email already exists";
                actualResult = registerButtons.actualResultEli(driver).getText();
                Assert.assertTrue(actualResult.contains(expectedResult), "The specified email already exists");
            }
        }
    }

    @Test(priority = 2,dataProvider = "data")
    public void testcase2_login(String email ,String pass) throws InterruptedException {
        if (email != "mohamedalifahmy2021@gmail.com"){
            loginButtons.loginButtonEle().click();
        }
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");


        loginButtons.writeEmailEle().sendKeys(email);
        loginButtons.writePasswordEle().sendKeys(pass);
        loginButtons.okButtonEle().click();
        Thread.sleep(5000);
        String expectedResult ;
        String actualResult;
        if (email != "mohamedalifahmy2021@gmail.com"){
            expectedResult ="Login was unsuccessful. Please correct the errors and try again";
            actualResult =driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getText();
        }else {
            expectedResult = "Log out";
            actualResult = loginButtons.actualResult().getText();
        }
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test(priority = 3)
    public void testcase3_Search() throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        searchButtons.searchFieldEle().sendKeys("computer");
        searchButtons.searchButtonEle().click();
        String expectedResult1 = "Build your own computer";
        String actualResult1 = searchButtons.actualResultEle1().getText();
        Thread.sleep(3000);
        soft.assertTrue(actualResult1.contains(expectedResult1));
        searchButtons.searchFieldEle() .sendKeys("camera");
        searchButtons.searchButtonEle() .click();
        String expectedResult2 = "Leica T Mirrorless Digital Camera";
        String actualResult2 = searchButtons.actualResultEle2().getText();
        soft.assertTrue(actualResult2.contains(expectedResult2));
        searchButtons.searchFieldEle().sendKeys("book");
        searchButtons.searchButtonEle().click();

    }

    @Test(priority = 4)
    public void testcase4_addComputerToCart() throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        driver.navigate().to("https://demo.nopcommerce.com/");

       addComputerToCart.addComputer().click();
        Thread.sleep(3000);
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/build-your-own-computer");
        Select processor = new Select(addComputerToCart.selectProcessor());
        processor.selectByIndex(1);
        Select ram = new Select(addComputerToCart.selectRam());
        ram.selectByIndex(2);
        addComputerToCart.chooseHDD().click();
        addComputerToCart.chooseOS().click();
        addComputerToCart.chooseSoftware().click();
        addComputerToCart.addToCard().click();
        addComputerToCart.goToCard().click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(addComputerToCart.waitingUntil()));
        String actualResult = addComputerToCart.actualResult().getText();
        String expectedResult = "Build your own computer";
        soft.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 5)
    public void testCase5_addLapTobToCart() {
        SoftAssert soft = new SoftAssert();

        driver.navigate().to("https://demo.nopcommerce.com/");
        addLaptopButtons.chooseLaptop().click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(addLaptopButtons.byCard()));
       addLaptopButtons.addToCardButton().click();
        addLaptopButtons.toCardButton().click();
        String actualResult = addLaptopButtons.actualResult().getText();
        String expectedResult = "Apple MacBook Pro 13-inch";
        soft.assertTrue(actualResult.contains(expectedResult));

    }

    @Test(priority = 6)
    public void testCase6_CheckAddToCart() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        addComputerToCart.goToCard().click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(checkAddToCart.waitElement()));
        Thread.sleep(1000);
       checkAddToCart.numberLaptopItems().clear();
        checkAddToCart.numberLaptopItems().sendKeys("3");
        String expected = "4140";
        String actual = checkAddToCart.actualResult().getText();
        soft.assertTrue(actual.contains(expected));
    }

    @Test(priority = 7)
    public void testCase7_CheckSocialMedia() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        Actions a = new Actions(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");
        String parent = driver.getWindowHandle();
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(checkSocialMedia.waitingElement()));
        WebElement aa = checkSocialMedia.facebookButton();
        new Actions(driver)
                .click(aa)
                .perform();
        checkSocialMedia.facebookButton().click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equalsIgnoreCase(parent)) {
                driver.switchTo().window(window);
                String actual1 = driver.getCurrentUrl();
                String expected1 = "https://www.facebook.com/nopCommerce";
                soft.assertTrue(actual1.contains(expected1));
                Thread.sleep(1000);
                driver.close();
            }
        }
       driver.switchTo().window(parent);

       Thread.sleep(1000);
        checkSocialMedia.twitterButton().click();
        allWindows=driver.getWindowHandles();
        for (String window:allWindows){
            if(!window.equalsIgnoreCase(parent)) {
                driver.switchTo().window(window);
                String actual1 = driver.getCurrentUrl();
                String expected1="https://twitter.com/nopCommerce";
                soft.assertEquals(actual1,expected1);
                Thread.sleep(1000);
                driver.close();
            }

        }
        driver.switchTo().window(parent);

        Thread.sleep(1000);
        checkSocialMedia.demoButton().click();
        allWindows=driver.getWindowHandles();
        for (String window:allWindows){
            if(!window.equalsIgnoreCase(parent)) {
                driver.switchTo().window(window);
                String actual1 = driver.getCurrentUrl();
                String expected1="https://demo.nopcommerce.com/news/rss/1";
                soft.assertEquals(actual1,expected1);
                Thread.sleep(1000);
                driver.close();
            }

        }
        driver.navigate().back();

        Thread.sleep(1000);
        checkSocialMedia.youtubeButton().click();
        allWindows=driver.getWindowHandles();
        for (String window:allWindows){
            if(!window.equalsIgnoreCase(parent)) {
                driver.switchTo().window(window);
                String actual1 = driver.getCurrentUrl();
                String expected1="\"https://www.youtube.com/user/nopCommerce\"";
                soft.assertEquals(actual1,expected1);
                Thread.sleep(1000);
                driver.close();
            }

        }


    }
    @DataProvider(name = "data")
    public Object[][] data1(){
        return new Object[][]{
                {"mohamedalifahmy2021@gmail.com", "123456"},
                {"kareeem@gmail.com", "123456"},
        };
    }

    @AfterClass
    public void AfterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
