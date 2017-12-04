package com.isa.spring.security.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static AdminPage to(WebDriver webDriver) {
        get(webDriver, "admin/admin.html");
        return PageFactory.initElements(webDriver, AdminPage.class);
    }
}
