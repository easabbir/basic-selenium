import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class TestAddToCart extends BaseClass{



    @Test
    public void testAddToCart() throws InterruptedException {
        BaseClass.setupDriver();
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();



    }
}
