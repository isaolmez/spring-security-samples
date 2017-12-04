package com.isa.spring.security.guide;

import com.isa.spring.security.guide.common.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class ApplicationContextTest extends BaseTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldLoadContext() {
        // Do nothing
    }
}
