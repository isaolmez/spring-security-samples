package com.isa.spring.security.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage extends BasePage {

    @FindBy(id = "admin")
    private WebElement adminLink;

    @FindBy(id = "logout")
    private WebElement logoutLink;

    public AdminHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getAdminLink() {
        return adminLink;
    }

    public WebElement getLogoutLink() {
        return logoutLink;
    }

    public <T extends BasePage> T toAdminPage(Class<T> resultPage) {
        this.adminLink.click();
        return PageFactory.initElements(webDriver, resultPage);
    }

    public LoginPage logout() {
        this.logoutLink.click();
        return PageFactory.initElements(webDriver, LoginPage.class);
    }
}
