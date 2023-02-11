package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomerCreation {

    WebDriver driver;

    public CustomerCreation(WebDriver driver){
        this.driver=driver;
    }

    public void setFirstName(String firstName){
        waitUntillNextElementApear(driver,By.name("fname"), Duration.ofSeconds(10));
        driver.findElement(By.name("fname")).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        waitUntillNextElementApear(driver,By.name("lname"), Duration.ofSeconds(10));
        driver.findElement(By.name("lname")).sendKeys(lastName);
    }
    public void setEmail(String email){
        waitUntillNextElementApear(driver,By.name("email"), Duration.ofSeconds(10));
        driver.findElement(By.name("email")).sendKeys(email);
    }
    public void setPassword(String password){
        waitUntillNextElementApear(driver,By.name("password"), Duration.ofSeconds(10));
        driver.findElement(By.name("password")).sendKeys(password);
    }
    public void setMobile(String mobile){
        waitUntillNextElementApear(driver,By.name("mobile"), Duration.ofSeconds(10));
        driver.findElement(By.name("mobile")).sendKeys(mobile);
    }
    public void setAddress01(String addressOne){
        waitUntillNextElementApear(driver,By.name("address1"), Duration.ofSeconds(10));
        driver.findElement(By.name("address1")).sendKeys(addressOne);
    }
    public void setAddress02(String addressTwo){
        waitUntillNextElementApear(driver,By.name("address2"), Duration.ofSeconds(10));
        driver.findElement(By.name("address2")).sendKeys(addressTwo);
    }
    public void selectDropDown(){
        waitUntillNextElementApear(driver,By.name("country"), Duration.ofSeconds(10));
        Select dropdownCountry = new Select(driver.findElement(By.name("country")));
        dropdownCountry.selectByVisibleText("Afghanistan");
        dropdownCountry.selectByValue("BI");
        dropdownCountry.selectByIndex(5);
    }
    public void saveCustomer(){
        waitUntillNextElementApear(driver,By.xpath("//button[@type='submit']"), Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public String successMsg(){
        List<WebElement> successElement = driver.findElements(By.xpath("//*[text()=\'Customers Management\']"));
        String saveMessage = successElement.get(1).getText();
        return saveMessage;
    }

    private WebElement waitUntillNextElementApear(WebDriver driver, By locator, Duration timeOut){
        WebElement element = new WebDriverWait(driver,timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }



}
