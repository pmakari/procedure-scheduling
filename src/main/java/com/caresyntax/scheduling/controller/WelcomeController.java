package com.caresyntax.scheduling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Parviz on 10.05.2018.
 */
@Controller
public class WelcomeController {

    @GetMapping("/")
    public String index() {
        return "patient/show";
    }
}
