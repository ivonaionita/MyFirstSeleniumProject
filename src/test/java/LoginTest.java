import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

@Test
    public void loginUser(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("ivona_930@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement helloMessage=driver.findElement(By.cssSelector(".hello >strong"));
        Assert.assertTrue(helloMessage.isDisplayed());
    }
@Test
    public void loginUserWithoutMailExtention(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("ivona_930");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement required=driver.findElement(By.cssSelector("p.required"));
        Assert.assertTrue(required.isDisplayed());
    }
@Test
    public void loginUserWithinvalidCredentials(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("abc@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("12345eer6");
        driver.findElement(By.cssSelector("#send2 ")).click();
        WebElement errorMessage= driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
@Test
    public void forgotPasswordButton(){
    driver.findElement(By.cssSelector(".skip-account .label")).click();
    driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
    driver.findElement(By.cssSelector("#login-form > div > div.col-2.registered-users > div.content.fieldset > ul > li:nth-child(3) > a")).click();
    WebElement forgotPassword= driver.findElement(By.cssSelector("div.page-title > h1"));
    Assert.assertTrue(forgotPassword.isDisplayed());
    }
@Test
    public void loginWithoutCredentials(){
    driver.findElement(By.cssSelector(".skip-account .label")).click();
    driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
    driver.findElement(By.id("send2"));
    WebElement redMessage1=driver.findElement(By.cssSelector("#advice-required-entry-email"));
    Assert.assertTrue(redMessage1.isDisplayed());
    WebElement redMessage2=driver.findElement(By.cssSelector("#advice-required-entry-pass"));
    Assert.assertTrue(redMessage2.isDisplayed());
}
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
