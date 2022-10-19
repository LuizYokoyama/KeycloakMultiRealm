package com.ls.multiRealm.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin(origins = "*")
public class auth {

    @GetMapping("/test")
    public String getTest(@AuthenticationPrincipal Jwt jwt){

        return "Test OK" +
                "<p>Realm: "+jwt.getIssuer().toString();
    }

}
