package com.pharmacy.pharmacymanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class PersonController {
    @GetMapping
    String getHome(){
        return "home";
    }
}
