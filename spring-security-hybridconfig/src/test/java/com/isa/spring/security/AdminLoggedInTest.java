package com.isa.spring.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
public class AdminLoggedInTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private final String noAccessUrl = "/noaccess.html";

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void shouldAccess_LoginPage_WhenAdminIsLoggedIn() throws Exception {
        mockMvc.perform(get("/login.html"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAccess_HelloPage_WhenAdminIsLoggedIn() throws Exception {
        mockMvc.perform(get("/hello.html"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotAccess_AnonymousPage_WhenAdminIsLoggedIn() throws Exception {
        mockMvc.perform(get("/anonymous.html"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(noAccessUrl));
    }

    @Test
    public void shouldAccess_HomePage_WhenAdminIsLoggedIn() throws Exception {
        mockMvc.perform(get("/home.html"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAccess_UserPage_WhenAdminIsLoggedIn() throws Exception {
        mockMvc.perform(get("/user/user.html"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAccess_AdminPage_WhenAdminIsLoggedIn() throws Exception {
        mockMvc.perform(get("/admin/admin.html"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
