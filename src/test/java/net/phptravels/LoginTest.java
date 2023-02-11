package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.PropertyFileReader;

import java.util.List;

public class LoginTest {

    PropertyFileReader prop = new PropertyFileReader();
    String url = prop.getProperty("config","url");

    @Test
    public void testLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("admin@phptravels.com");
        email.clear();
        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);
        //String actual = driver.findElement(By.xpath("//*[contains(text(),'Invalid Login')]")).getText();
        //Assert.assertEquals(actual,"Invalid Login Credentials");

        List<WebElement> message = driver.findElements(By.xpath("//*[text()='Dashboard']"));
        String actualHomepagemessage = message.get(2).getText();
        Assert.assertEquals(actualHomepagemessage,"Dashboard","failed to login");
        driver.findElement(By.id("dropdownMenuProfile")).click();
        Thread.sleep(2000);
        //driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.xpath("//*[text() = 'Logout']"));

        driver.quit();

    }
}
