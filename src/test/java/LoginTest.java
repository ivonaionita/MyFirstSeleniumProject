import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        LoginTest runtest= new LoginTest();
        runtest.loginUser();

    }

    public void loginUser(){
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.icon")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        WebElement elementE= driver.findElement(By.id("email"));
        elementE.sendKeys("ivona_930@yahoo.com");
        WebElement elementP= driver.findElement(By.id("pass"));
        elementP.click();
        elementP.sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.quit();
    }
}
