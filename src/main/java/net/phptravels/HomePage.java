package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestApp;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver = TestApp.getInstance().getDriver();


    public HomePage selectAccountMenu(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[@href='javascript:void(0);']"), Duration.ofSeconds(10));
        List<WebElement> menuElementAccounts = driver.findElements(By.xpath("//*[@href='javascript:void(0);']"));
        menuElementAccounts.get(2).click();
        return this;
    }

    public CustomerManagementPage selectCustomerMenu(){
        TestApp.getInstance().waitUntilNextElementAppears(By.linkText("Customers"), Duration.ofSeconds(5));
        driver.findElement(By.linkText("Customers")).click();
        return new CustomerManagementPage();
    }


}
