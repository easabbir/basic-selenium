import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestLogin extends BaseClass {

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        setupDriver();
        login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getTitle(),"Swag Labs");

    }


    @Test
    public void testLoginWithInvalidCredentials() throws InterruptedException {
        setupDriver();
        login("standard_user", "secret_saucesasdfasd");

        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(),"Epic sadface: Username and password do not match any user in this service");
    }

    public void login(String username, String password){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
