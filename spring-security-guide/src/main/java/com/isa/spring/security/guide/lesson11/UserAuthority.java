package com.isa.spring.security.guide.lesson11;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority {

  private final String permission;

  public UserAuthority(String permission) {
    this.permission = permission;
  }

  @Override
  public String getAuthority() {
    return permission;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserAuthority that = (UserAuthority) o;

    return permission != null ? permission.equals(that.permission) : that.permission == null;
  }

  @Override
  public int hashCode() {
    return permission != null ? permission.hashCode() : 0;
  }
}
