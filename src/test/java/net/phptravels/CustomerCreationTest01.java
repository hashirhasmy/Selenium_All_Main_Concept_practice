package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CustomerCreationTest01 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.net/api/admin");
        driver.manage().window().maximize();

        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        waitUntillNextElementApear(By.xpath("//*[@href='javascript:void(0);']"), Duration.ofSeconds(10));

        List<WebElement> menuElementAccounts = driver.findElements(By.xpath("//*[@href='javascript:void(0);']"));
        menuElementAccounts.get(2).click();
        waitUntillNextElementApear(By.linkText("Customers"),Duration.ofSeconds(5));
        driver.findElement(By.linkText("Customers")).click();
        waitUntillNextElementApear(By.xpath("//button[@type='submit']"),Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        waitUntillNextElementApear(By.name("fname"),Duration.ofSeconds(10));
    }

    @Test
    public void testCreateCustomer() throws InterruptedException {

        driver.findElement(By.name("fname")).sendKeys("Mohamed");
        driver.findElement(By.name("lname")).sendKeys("Hashir");
        driver.findElement(By.name("email")).sendKeys("Hashir@gmail.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.name("mobile")).sendKeys("0776808389");
        driver.findElement(By.name("address1")).sendKeys("mathugama, Horwala");
        driver.findElement(By.name("address2")).sendKeys("mathugama, Horwala");

        Select dropdownCountry = new Select(driver.findElement(By.name("country")));
        dropdownCountry.selectByVisibleText("Afghanistan");
        dropdownCountry.selectByValue("BI");
        dropdownCountry.selectByIndex(5);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private WebElement waitUntillNextElementApear(By locator, Duration timeOut){
        WebElement element = new WebDriverWait(driver,timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

}
