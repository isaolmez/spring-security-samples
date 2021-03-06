package com.isa.spring.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class NoneLoggedInTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private final String authRequiredUrlPattern = "**/login.html";

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void shouldAccess_LoginPage_WithoutAuthentication() throws Exception {
        mockMvc.perform(get("/login.html"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAccess_HelloPage_WithoutAuthentication() throws Exception {
        mockMvc.perform(get("/hello.html"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAccess_AnonymousPage_WithoutAuthentication() throws Exception {
        mockMvc.perform(get("/anonymous.html"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotAccess_HomePage_WithoutAuthentication() throws Exception {
        mockMvc.perform(get("/home.html"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(authRequiredUrlPattern));
    }

    @Test
    public void shouldNotAccess_UserPage_WithoutAuthentication() throws Exception {
        mockMvc.perform(get("/user/user.html"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(authRequiredUrlPattern));
    }

    @Test
    public void shouldNotAccess_AdminPage_WithoutAuthentication() throws Exception {
        mockMvc.perform(get(authRequiredUrlPattern))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(authRequiredUrlPattern));
    }

    @Test
    public void shouldNotAccess_NoAccessPage_WithoutAuthentication() throws Exception {
        mockMvc.perform(get("/noaccess.html"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(authRequiredUrlPattern));
    }
}
