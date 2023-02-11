package net.phptravels;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyFileReader;
import utils.TestApp;

public class CustomerCreationTest04 {

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
        //1st method
        homePage = loginPage.loginSuccess("admin@phptravels.com",password);
        customerManagementPage = homePage.selectAccountMenu().selectCustomerMenu();
        customerCreationPage = customerManagementPage.addCustomer();



    }

    @Test
    public void testName() {
//        2nd method
//        loginPage
//        .loginSuccess("admin@phptravels.com",password)
//        .selectAccountMenu()
//        .selectCustomerMenu()
//        .addCustomer();

        customerManagementPage = customerCreationPage
                .setFirstName("Mohamed")
                .setLastName("Hashir")
                .setEmail("Hashirvijay@gmail.com")
                .setPassword("password123")
                .setMobile("0776808389")
                .setAddress01("mathugama, Horwala")
                .setAddress02("mathugama, Horwala")
                .selectDropDown()
                .saveCustomer();

    }

    @AfterMethod
    public void tearDown() {

    }
}
