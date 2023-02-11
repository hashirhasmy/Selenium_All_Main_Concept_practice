package net.phptravels;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyFileReader;
import utils.TestApp;

public class CustomerCreationTest03 {

    LoginPage loginPage;
    HomePage homePage;
    CustomerManagementPage customerManagementPage;
    CustomerCreationPage customerCreationPage;

    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String password = propertyFileReader.getProperty("config","pass");

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        loginPage = new LoginPage();
        loginPage.loginSuccess("admin@phptravels.com",password);
        homePage = new HomePage();
        homePage.selectAccountMenu();
        homePage.selectCustomerMenu();
        customerManagementPage = new CustomerManagementPage();
        customerManagementPage.addCustomer();
        customerCreationPage = new CustomerCreationPage();
    }

    @Test
    public void testCreateCustomer() {
        customerCreationPage.setFirstName("Mohamed");
        customerCreationPage.setLastName("Hashir");
        customerCreationPage.setEmail("Hashiruniq88@gmail.com");
        customerCreationPage.setPassword("password123");
        customerCreationPage.setMobile("0776808389");
        customerCreationPage.setAddress01("mathugama, Horwala");
        customerCreationPage.setAddress02("mathugama, Horwala");
        customerCreationPage.selectDropDown();
        customerCreationPage.saveCustomer();
    }

    @AfterMethod
    public void tearDown() {
        //TestApp.getInstance().closeBrowser();

    }
}
