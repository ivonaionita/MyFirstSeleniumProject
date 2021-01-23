import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.WeakHashMap;
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
    }
}
