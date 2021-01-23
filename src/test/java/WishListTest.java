import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
    public static void main(String[] args) {
        WishListTest runtest=new WishListTest();
        runtest.addProductToWishList();

    }


    public  void addProductToWishList(){
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(" http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-403")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        driver.quit();

    }

}
