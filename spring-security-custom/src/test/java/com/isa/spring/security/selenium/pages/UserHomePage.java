package com.isa.spring.security.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage extends BasePage {

    @FindBy(id = "user")
    private WebElement userLink;

    @FindBy(id = "logout")
    private WebElement logoutLink;

    public UserHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getUserLink() {
        return userLink;
    }

    public WebElement getLogoutLink() {
        return logoutLink;
    }

    public <T extends BasePage> T toUserPage(Class<T> resultPage) {
        this.userLink.click();
        return PageFactory.initElements(webDriver, resultPage);
    }

    public LoginPage logout() {
        this.logoutLink.click();
        return PageFactory.initElements(webDriver, LoginPage.class);
    }
}
