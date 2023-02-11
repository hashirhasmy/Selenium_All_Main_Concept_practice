package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerManagement {


    public void addCustomer(WebDriver driver){
        waitUntillNextElementApear(driver,By.xpath("//button[@type='submit']"),Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private WebElement waitUntillNextElementApear(WebDriver driver, By locator, Duration timeOut){
        WebElement element = new WebDriverWait(driver,timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

}
