import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {

    public static WebDriver driver;

    public static void setupDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome options to disable password manager popup
        ChromeOptions options = new ChromeOptions();
        
        // Disable password manager arguments
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-blink-features=AutomationControlled");
        
        // Comprehensive preferences to disable all password manager features
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("autofill.profile_enabled", false);
        
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        //driver.get("https://trytestingthis.netlify.app/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



    }
}
