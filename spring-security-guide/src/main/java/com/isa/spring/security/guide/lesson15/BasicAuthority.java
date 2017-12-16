package com.isa.spring.security.guide.lesson15;

import org.springframework.security.core.GrantedAuthority;

public class BasicAuthority implements GrantedAuthority {

    private final String authority;

    public BasicAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BasicAuthority that = (BasicAuthority) o;

        return authority != null ? authority.equals(that.authority) : that.authority == null;
    }

    @Override
    public int hashCode() {
        return authority != null ? authority.hashCode() : 0;
    }
}