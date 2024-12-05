package com.isa.spring.security.guide.lesson9;

import org.springframework.context.annotation.Profile;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Profile("lesson9")
public class WhoIsController {

  @Secured("ROLE_USER")
  @GetMapping(value = "/whois")
  public String whois() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    StringBuilder builder = new StringBuilder();
    builder.append("principal: ").append(getPrincipal(authentication));
    builder.append(",");
    builder.append("authorities: ").append(authentication.getAuthorities());
    return builder.toString();
  }

  private String getPrincipal(Authentication authentication) {
    if (authentication.getPrincipal() instanceof UserDetails) {
      return ((UserDetails) authentication.getPrincipal()).getUsername();
    } else {
      return authentication.getPrincipal().toString();
    }
  }
}
