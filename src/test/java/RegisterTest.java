import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    public static void main(String[] args) {
        RegisterTest runtest = new RegisterTest();
        runtest.registerNewUser();

    }

    public void registerNewUser() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        WebElement elementFN = driver.findElement(By.id("firstname"));
        elementFN.sendKeys("Ivona");
        WebElement elementLN = driver.findElement(By.id("lastname"));
        elementLN.click();
        elementLN.sendKeys("Ionita");
        WebElement elementEA = driver.findElement(By.id("email_address"));
        elementEA.click();
        elementEA.sendKeys("ivona930@gmail.com");
        WebElement elementPass = driver.findElement(By.id("password"));
        elementPass.click();
        elementPass.sendKeys("123456");
        WebElement elementCP = driver.findElement(By.id("confirmation"));
        elementCP.click();
        elementCP.sendKeys("123456");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.quit();
    }


}
