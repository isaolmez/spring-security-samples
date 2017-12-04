package com.isa.spring.security.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "input[type=submit]")
    private WebElement submit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public <T extends BasePage> T login(Class<T> resultPage, String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submit.click();
        return PageFactory.initElements(webDriver, resultPage);
    }

    public static LoginPage to(WebDriver webDriver) {
        get(webDriver, "login.html");
        return PageFactory.initElements(webDriver, LoginPage.class);
    }
}
