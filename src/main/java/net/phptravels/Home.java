package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Home {

    public void selectAccountMenu(WebDriver driver){
        waitUntillNextElementApear(driver,By.xpath("//*[@href='javascript:void(0);']"), Duration.ofSeconds(10));
        List<WebElement> menuElementAccounts = driver.findElements(By.xpath("//*[@href='javascript:void(0);']"));
        menuElementAccounts.get(2).click();
    }

    public void selectCustomerMenu(WebDriver driver){
        waitUntillNextElementApear(driver,By.linkText("Customers"), Duration.ofSeconds(5));
        driver.findElement(By.linkText("Customers")).click();
    }

    private WebElement waitUntillNextElementApear(WebDriver driver,By locator, Duration timeOut){
        WebElement element = new WebDriverWait(driver,timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }
}
