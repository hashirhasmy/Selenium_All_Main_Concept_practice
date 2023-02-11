package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerCreationTest02 {

    WebDriver driver;
    Login login;
    Home home;
    CustomerManagement customerManagement;
    CustomerCreation customerCreation;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.net/api/admin");
        driver.manage().window().maximize();
        login = new Login();
        login.loginAs(driver,"admin@phptravels.com","demoadmin");
        home = new Home();
        home.selectAccountMenu(driver);
        home.selectCustomerMenu(driver);
        customerManagement = new CustomerManagement();
        customerManagement.addCustomer(driver);
    }

    @Test
    public void testCustomerCreation() {

        customerCreation = new CustomerCreation(driver);
        customerCreation.setFirstName("Mohamed");
        customerCreation.setLastName("Hashir");
        customerCreation.setEmail("Hashiruniq@gmail.com");
        customerCreation.setPassword("password123");
        customerCreation.setMobile("0776808389");
        customerCreation.setAddress01("mathugama, Horwala");
        customerCreation.setAddress02("mathugama, Horwala");
        customerCreation.selectDropDown();
        customerCreation.saveCustomer();
        Assert.assertEquals(customerCreation.successMsg(),"Customers Management","fail message should pop up");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
