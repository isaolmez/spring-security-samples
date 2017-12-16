package com.isa.spring.security.guide.lesson14;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.isa.spring.security.guide.common.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ActiveProfiles("lesson14")
public class SecurityConfigTest extends BaseTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    @Test
    public void shouldRedirectToLogin() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrlPattern("**/login"))
                .andExpect(unauthenticated());
    }

    @Test
    public void shouldLogin() throws Exception {
        mockMvc.perform(formLogin().user("user").password("password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(authenticated().withUsername("user").withRoles("USER"));
    }

    @Test
    public void shouldFailAtLogin() throws Exception {
        mockMvc.perform(formLogin().user("user").password("wrongPass"))
                .andExpect(status().is3xxRedirection())
                .andExpect(unauthenticated());
    }

    @Test
    public void shouldLogout() throws Exception {
        mockMvc.perform(logout())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?logout"))
                .andExpect(unauthenticated());
    }

    @Test
    public void shouldAccessUserPathWithUser() throws Exception {
        mockMvc.perform(get("/api/user").with(user("user").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(content().string("USER"));
    }

    @Test
    public void shouldNotAccessUserPathWithAdmin() throws Exception {
        mockMvc.perform(get("/api/user").with(user("admin").roles("ADMIN")))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldAccessAdminPathWithAdmin() throws Exception {
        mockMvc.perform(get("/api/admin").with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().string("ADMIN"));
    }

    @Test
    public void shouldNotAccessAdminPathWithUser() throws Exception {
        mockMvc.perform(get("/api/admin").with(user("user").roles("USER")))
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void shouldAccessUserAndAdmin() throws Exception {
        mockMvc.perform(get("/api/userAndAdmin").with(user("admin").roles("USER", "ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().string("USER AND ADMIN"));
    }

    @Test
    public void shouldNotAccessUserAndAdmin() throws Exception {
        mockMvc.perform(get("/api/userAndAdmin").with(user("admin").roles("ADMIN")))
                .andExpect(status().is4xxClientError());
    }
}
