package com.masai.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("")
    public String home(){
        return "User Services";
    }

}
