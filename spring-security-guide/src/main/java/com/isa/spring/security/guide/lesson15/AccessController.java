package com.isa.spring.security.guide.lesson15;

import org.springframework.context.annotation.Profile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Profile("lesson15")
public class AccessController {

  @PreAuthorize("hasAuthority('SITEA')")
  @GetMapping(value = "/sitea")
  public String siteA() {
    return "SITEA";
  }

  @PreAuthorize("hasAuthority('SITEB')")
  @GetMapping(value = "/siteb")
  public String siteB() {
    return "SITEB";
  }

  @PreAuthorize("hasAuthority('SITEA') AND hasAuthority('SITEB')")
  @GetMapping(value = "/siteab")
  public String siteAB() {
    return "SITEAB";
  }
}
