package com.isa.spring.security.selenium.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    static void get(WebDriver driver, String relativeUrl) {
        String url = String.format("http://localhost:8090/%s", relativeUrl);
        driver.get(url);
    }
}
