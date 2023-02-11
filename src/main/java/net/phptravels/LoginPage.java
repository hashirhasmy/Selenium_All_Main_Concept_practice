package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

import java.time.Duration;

public class LoginPage {

    WebDriver driver = TestApp.getInstance().getDriver();

    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String userNameElement = propertyFileReader.getProperty("LoginPage","user.name.element");
    String passwordElement = propertyFileReader.getProperty("LoginPage","user.password.element");
    String loginButtonElement = propertyFileReader.getProperty("LoginPage","login.button.element");

    public HomePage loginSuccess(String userName, String password){
        loginAs(userName,password);
        return new HomePage();
    }

    public LoginPage loginunsuccessAs(String userName, String password) {
        loginAs(userName,password);
        return this;
    }

    private void loginAs(String userName, String password){
        TestApp.getInstance().waitUntilNextElementAppears(By.name(userNameElement), Duration.ofSeconds(10));
        driver.findElement(By.name(userNameElement)).sendKeys(userName);
        driver.findElement(By.name(passwordElement)).sendKeys(password);
        driver.findElement(By.xpath(loginButtonElement)).click();
    }

}
