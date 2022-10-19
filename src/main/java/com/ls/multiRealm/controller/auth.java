package com.ls.multiRealm.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin(origins = "*")
public class auth {

    @GetMapping("/test")
    public String getTest(){


        return "teste OK Teste OK";
    }

}
