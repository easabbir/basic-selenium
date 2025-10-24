package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.BaseTest;
import pages.LoginPage;


import java.util.List;

public class TestAddToCart extends BaseTest {



    @Test
    public void testAddToCart() throws InterruptedException {
        setupDriver();

        LoginPage loginObj = new LoginPage(driver);
        loginObj.login("standard_user", "secret_sauce");

        WebElement addToCartBackpack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCartBackpack.click();

        WebElement bikeLight = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']"));
        bikeLight.click();

        WebElement boltTshirt = driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']"));
        boltTshirt.click();

        WebElement fleeceJacket = driver.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart-sauce-labs-fleece-jacket')]"));
        fleeceJacket.click();

        logout();





//        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item']"));
//
//        // Click the "Add to cart" button within each inventory item (expected 6)
//        for (WebElement item : items) {
//            WebElement addButton = item.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
//            Thread.sleep(1000);
//            addButton.click();
//        }
//
//        System.out.println("Added to cart: " + items.size() + " items");

        //addAllItemsToCart();



    }

    public void logout(){
        WebElement menu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        menu.click();

        WebElement logoutButton = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logoutButton.click();
    }

    public void login(String username, String password){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    private void addAllItemsToCart() throws InterruptedException {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        System.out.println(items);
        // Click the "Add to cart" button within each inventory item (expected 6)
        for (WebElement item : items) {
            WebElement addButton = item.findElement(By.xpath(".//button[contains(text(),'Add to cart')]"));
            addButton.click();
            Thread.sleep(2000);
        }
        System.out.println("Added to cart: " + items.size() + " items");
    }


    @AfterMethod
    public void closeBrowser (){
        driver.quit();
    }
}
