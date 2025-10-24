package tests;

import utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getPageTitle(), "Swag Labs", "Login failed for valid credentials!");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Error message mismatch!");
    }
}
