package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestApp;

import java.time.Duration;

public class CustomerManagementPage {

    WebDriver driver = TestApp.getInstance().getDriver();

    public CustomerCreationPage addCustomer(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//button[@type='submit']"), Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return new CustomerCreationPage();
    }


}
