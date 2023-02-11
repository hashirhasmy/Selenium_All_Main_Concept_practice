package com.guru99.demo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.TestApp;

public class RegisterUserStepDef {


    HomePage homePage;
    RegisterPage registerPage;
    RegisterSuccessPage regSuccessPage;

    @Given("User is on Mercury Home Page --> Register Page")
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        homePage = PageFactory.initElements(TestApp.getInstance().getDriver(),HomePage.class);
        registerPage = homePage.selectRegisterMenu();
    }

    @Given("User enter first name as {string}")
    public void setFirstName(String firstName) {
        registerPage.setFirstName(firstName);
    }

    @And("User enter last name as {string}")
    public void setLastName(String lastName) {
        registerPage.setLastName(lastName);
    }

    @And("User enter phone number as {string}")
    public void setPhone(String phone) {
        registerPage.setPhoneNumber(phone);
    }

    @And("User enter email address as {string}")
    public void setEmail(String email) {
        registerPage.setEmail(email);
    }

    @And("User enter user name as {string}")
    public void setUserName(String userName) {
        registerPage.setUserName(userName);
    }

    @And("user enter password as {string}")
    public void setPassword(String password) {
        registerPage.setPassword(password);
    }

    @And("user enter confirm password as {string}")
    public void setConfirmPassword(String confirmPassword) {
        registerPage.setConfirmPassword(confirmPassword);
    }

    @When("User clicks on submit")
    public void submit() {
        regSuccessPage = registerPage.submit();
    }

    @Then("Salutation message will display as {string}")
    public void verifySalutationMessage(String expectedMessage) {
        Assert.assertEquals(regSuccessPage.successText().getText(),expectedMessage,"Failed to Create new User");
    }
}
