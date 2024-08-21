package com.example.demos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StartController {
    @GetMapping(value="")
    public String mainPage(){
        return "start";
    }
}
