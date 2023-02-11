package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.TestApp;

import java.time.Duration;

public class CustomerCreationPage {

    WebDriver driver = TestApp.getInstance().getDriver();

    public CustomerCreationPage setFirstName(String firstName) {
        TestApp.getInstance().waitUntilNextElementAppears(By.name("fname"), Duration.ofSeconds(10));
        driver.findElement(By.name("fname")).sendKeys(firstName);
        return this;
    }

    public CustomerCreationPage setLastName(String lastName) {
        TestApp.getInstance().waitUntilNextElementAppears(By.name("lname"), Duration.ofSeconds(10));
        driver.findElement(By.name("lname")).sendKeys(lastName);
        return this;
    }

    public CustomerCreationPage setEmail(String email) {
        TestApp.getInstance().waitUntilNextElementAppears(By.name("email"), Duration.ofSeconds(10));
        driver.findElement(By.name("email")).sendKeys(email);
        return this;
    }

    public CustomerCreationPage setPassword(String password) {
        TestApp.getInstance().waitUntilNextElementAppears(By.name("password"), Duration.ofSeconds(10));
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public CustomerCreationPage setMobile(String mobile){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("mobile"), Duration.ofSeconds(10));
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        return this;
    }
    public CustomerCreationPage setAddress01(String addressOne){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("address1"), Duration.ofSeconds(10));
        driver.findElement(By.name("address1")).sendKeys(addressOne);
        return this;
    }
    public CustomerCreationPage setAddress02(String addressTwo){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("address2"), Duration.ofSeconds(10));
        driver.findElement(By.name("address2")).sendKeys(addressTwo);
        return this;
    }
    public CustomerCreationPage selectDropDown(){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("country"), Duration.ofSeconds(10));
        Select dropdownCountry = new Select(driver.findElement(By.name("country")));
        dropdownCountry.selectByVisibleText("Afghanistan");
        dropdownCountry.selectByValue("BI");
        dropdownCountry.selectByIndex(5);
        return this;
    }
    public CustomerManagementPage saveCustomer(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//button[@type='submit']"), Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return new CustomerManagementPage();
    }

}
