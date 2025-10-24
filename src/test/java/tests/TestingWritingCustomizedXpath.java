package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.BaseTest;


public class TestingWritingCustomizedXpath extends BaseTest {


    @Test
    public void testWritingCustomizedXpath() throws InterruptedException {
        setupDriver();
        //driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Ayushi");

        //ADDITIONAL TECHNIQUE TO IDENTIFY DYNAMIC CONTENT
        driver.findElement(By.xpath("//input[starts-with(@id,'fname')]")).sendKeys("Ayushi");
        Thread.sleep(3000);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
