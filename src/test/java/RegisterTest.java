import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

   private WebDriver driver;

   @Before
   public void setupDriver(){
       System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
       driver = new ChromeDriver();
       driver.get("http://testfasttrackit.info/selenium-test/");
   }

    @Test
    public void registerNewUser() {


         driver.findElement(By.cssSelector(".skip-account .label")).click();
         driver.findElement(By.cssSelector(".links li:nth-child(5)")).click();
         driver.findElement(By.id("firstname")).sendKeys("Ivona");
         driver.findElement(By.id("lastname")).sendKeys("Ionita");
         driver.findElement(By.id("email_address")).sendKeys("ivona930abcd@gmail.com");
         driver.findElement(By.id("password")).sendKeys("123456");
         driver.findElement(By.id("confirmation")).sendKeys("123456");
         driver.findElement(By.cssSelector(".control [for=\"is_subscribed\"]")).click();
         driver.findElement(By.cssSelector(".buttons-set [title=\"Register\"]")).click();
         WebElement registerMessage=driver.findElement(By.cssSelector(".messages  li  ul  li  span"));
         Assert.assertTrue(registerMessage.isDisplayed());
    }

    @Test
    public void registerNewUserWithoutName() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".links li:nth-child(5)")).click();
        driver.findElement(By.id("lastname")).sendKeys("Ionita");
        driver.findElement(By.id("email_address")).sendKeys("ivona930@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector(".buttons-set [title=\"Register\"]")).click();
        WebElement redMessage= driver.findElement(By.cssSelector("#advice-required-entry-firstname"));
        Assert.assertTrue(redMessage.isDisplayed());

    }

    @Test
    public void passwordDoesNotMatch() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".links li:nth-child(5)")).click();
        driver.findElement(By.id("lastname")).sendKeys("Ionita");
        driver.findElement(By.id("email_address")).sendKeys("ivona930@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456789");
        driver.findElement(By.cssSelector(".buttons-set [title=\"Register\"]")).click();
        WebElement redMessage= driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation"));
        Assert.assertTrue(redMessage.isDisplayed());
   }

   @Test
   public void accountAlreadyExisting(){
       driver.findElement(By.cssSelector(".skip-account .label")).click();
       driver.findElement(By.cssSelector(".links li:nth-child(5)")).click();
       driver.findElement(By.id("firstname")).sendKeys("Ivona");
       driver.findElement(By.id("lastname")).sendKeys("Ionita");
       driver.findElement(By.id("email_address")).sendKeys("ivona930abcd@gmail.com");
       driver.findElement(By.id("password")).sendKeys("123456");
       driver.findElement(By.id("confirmation")).sendKeys("123456");
       driver.findElement(By.cssSelector(".control [for=\"is_subscribed\"]")).click();
       driver.findElement(By.cssSelector(".buttons-set [title=\"Register\"]")).click();
       WebElement messageDisplayed= driver.findElement(By.cssSelector(".messages span"));
       Assert.assertTrue(messageDisplayed.isDisplayed());
   }

   @Test
   public void passwordNotSecure(){
       driver.findElement(By.cssSelector(".skip-account .label")).click();
       driver.findElement(By.cssSelector(".links li:nth-child(5)")).click();
       driver.findElement(By.id("firstname")).sendKeys("Ivona");
       driver.findElement(By.id("lastname")).sendKeys("Ionita");
       driver.findElement(By.id("email_address")).sendKeys("ivona930abcd@gmail.com");
       driver.findElement(By.id("password")).sendKeys("123");
       driver.findElement(By.id("confirmation")).sendKeys("123");
       driver.findElement(By.cssSelector(".buttons-set [title=\"Register\"]")).click();
       WebElement redMessage=driver.findElement(By.cssSelector("#advice-validate-password-password"));
       Assert.assertTrue(redMessage.isDisplayed());

   }


    @After
    public void closeBrowser(){
        driver.quit();
    }



}
