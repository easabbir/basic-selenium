import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    public static void setupDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.saucedemo.com/");
        driver.get("https://trytestingthis.netlify.app/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));



    }
}
