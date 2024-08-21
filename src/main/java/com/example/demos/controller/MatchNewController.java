package com.example.demos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MatchNewController {
    @GetMapping(value = "new-match")
    public String newMatchPage() {
        return "new-match";
    }
}
