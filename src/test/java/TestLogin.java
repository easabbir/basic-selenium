import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestLogin extends BaseClass {

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        setupDriver();
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");


        //writing customized xpath using the format //tagname[@attribute='value']
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        //input[@id='login-button']
        //input[@id='login-button']
        driver.findElement(By.xpath("//input[@id='login-button']")).click();


        Assert.assertEquals(driver.getTitle(),"Swag Labs");

    }


    @Test
    public void testLoginWithInvalidCredentials() throws InterruptedException {
        setupDriver();
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauces");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(),"Epic sadface: Username and password do not match any user in this service");

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
