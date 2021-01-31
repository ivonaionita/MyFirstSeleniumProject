import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
    private WebDriver driver;

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public  void addProductToWishList(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("ivona_930@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-403")).click();
        driver.findElement(By.cssSelector(".add-to-links .link-wishlist")).click();
        WebElement greenMessage= driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertTrue(greenMessage.isDisplayed());

    }

   @Test
   public void addAlreadyExistingInWishListProduct(){
       driver.findElement(By.cssSelector(".skip-account .label")).click();
       driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
       driver.findElement(By.id("email")).sendKeys("ivona_930@yahoo.com");
       driver.findElement(By.id("pass")).sendKeys("123456");
       driver.findElement(By.id("send2")).click();
       driver.findElement(By.cssSelector("li.level0.nav-5.parent > a")).click();
       driver.findElement(By.cssSelector("#product-collection-image-403")).click();
       driver.findElement(By.cssSelector(".add-to-links .link-wishlist")).click();
       WebElement greenMessage= driver.findElement(By.cssSelector(".success-msg span"));
       Assert.assertTrue(greenMessage.isDisplayed());

    }
 @Test
    public void addToWishlistLoggedOut(){
        driver.findElement(By.cssSelector("li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-403")).click();
        driver.findElement(By.cssSelector(".add-to-links .link-wishlist")).click();
        WebElement redirect= driver.findElement(By.cssSelector("#send2"));
        Assert.assertTrue(redirect.isDisplayed());
    }
@Test
    public void addToWishListFromLink(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("ivona_930@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector(".add-to-links .link-wishlist"));
        WebElement greenMessage= driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertTrue(greenMessage.isDisplayed());


}

@Test
    public void shareWishList(){
    driver.findElement(By.cssSelector(".skip-account .label")).click();
    driver.findElement(By.cssSelector(".last [title=\"Log In\"]")).click();
    driver.findElement(By.id("email")).sendKeys("ivona_930@yahoo.com");
    driver.findElement(By.id("pass")).sendKeys("123456");
    driver.findElement(By.id("send2")).click();
    driver.findElement(By.cssSelector("li.level0.nav-5.parent > a")).click();
    driver.findElement(By.cssSelector("#product-collection-image-403")).click();
    driver.findElement(By.cssSelector(".add-to-links .link-wishlist")).click();
    driver.findElement(By.cssSelector("button.button.btn-share > span > span"));
    driver.findElement(By.cssSelector("#email_address")).sendKeys("abc@yahoo.com");
    driver.findElement(By.cssSelector("#form-validate > div.buttons-set.form-buttons > button > span > span"));
    WebElement greenMessage= driver.findElement(By.cssSelector(".success-msg span"));
    Assert.assertTrue(greenMessage.isDisplayed());


}

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
