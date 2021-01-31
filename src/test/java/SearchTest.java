import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

        private WebDriver driver;

        @Before
        public void setupDriver(){
            System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
            driver = new ChromeDriver();
            driver.get("http://testfasttrackit.info/selenium-test/");
        }
@Test
        public void SearchProduct(){
            driver.findElement(By.cssSelector("#search")).sendKeys("linen blazer");
            WebElement product= driver.findElement(By.cssSelector("#product-collection-image-406"));
            Assert.assertTrue(product.isDisplayed());
        }
    @After
    public void closeBrowser(){
        driver.quit();
    }

}
