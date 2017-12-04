package com.isa.spring.security.selenium;

import com.isa.spring.security.selenium.pages.AdminHomePage;
import com.isa.spring.security.selenium.pages.LoginPage;
import com.isa.spring.security.selenium.pages.UserHomePage;
import com.isa.spring.security.selenium.pages.UserPage;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class LoginPageTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver(true);
    }

    @Test
    public void shouldLogin_AsUser() {
        LoginPage loginPage = LoginPage.to(webDriver);

        UserHomePage userHomePage = loginPage.login(UserHomePage.class, "user", "password");

        assertThat(userHomePage).isNotNull();
        assertThat(userHomePage.getUserLink().isDisplayed()).isTrue();
        assertThat(userHomePage.getLogoutLink().isDisplayed()).isTrue();
    }

    @Test
    public void shouldNotLogin_AsUser_WithWrongPassword() {
        LoginPage loginPage = LoginPage.to(webDriver);

        loginPage.login(LoginPage.class, "user", "123");

        assertThat(webDriver.getCurrentUrl()).contains("error=true");
    }

    @Test
    public void shouldNotLogin_AsUser_WithWrongUsername() {
        LoginPage loginPage = LoginPage.to(webDriver);

        loginPage.login(LoginPage.class, "123", "password");

        assertThat(webDriver.getCurrentUrl()).contains("error=true");
    }

    @Test
    public void shouldLogin_AsAdmin() {
        LoginPage loginPage = LoginPage.to(webDriver);

        AdminHomePage adminHomePage = loginPage.login(AdminHomePage.class, "admin", "password");

        assertThat(adminHomePage).isNotNull();
        assertThat(adminHomePage.getAdminLink().isDisplayed()).isTrue();
        assertThat(adminHomePage.getLogoutLink().isDisplayed()).isTrue();
    }

    @Test
    public void shouldNotLogin_AsAdmin_WithWrongPassword() {
        LoginPage loginPage = LoginPage.to(webDriver);

        loginPage.login(LoginPage.class, "admin", "123");

        assertThat(webDriver.getCurrentUrl()).contains("error=true");
    }

    @Test
    public void shouldNotLogin_AsAdmin_WithWrongUsername() {
        LoginPage loginPage = LoginPage.to(webDriver);

        loginPage.login(LoginPage.class, "123", "password");

        assertThat(webDriver.getCurrentUrl()).contains("error=true");
    }
}
