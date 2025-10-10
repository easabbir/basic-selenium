import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestAddToCart extends BaseClass{



    @Test
    public void testAddToCart() throws InterruptedException {
        BaseClass.setupDriver();
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();





        WebElement addToCartBackpack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCartBackpack.click();

        WebElement bikeLight = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']"));
        bikeLight.click();

        WebElement boltTshirt = driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']"));
        boltTshirt.click();

        WebElement fleeceJacket = driver.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart-sauce-labs-fleece-jacket')]"));
        fleeceJacket.click();

        WebElement menu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        menu.click();

        WebElement logoutButton = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logoutButton.click();





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
