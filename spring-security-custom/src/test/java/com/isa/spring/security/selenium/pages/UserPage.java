package com.isa.spring.security.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage {

    public UserPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static UserPage to(WebDriver webDriver) {
        get(webDriver, "admin/admin.html");
        return PageFactory.initElements(webDriver, UserPage.class);
    }
}
