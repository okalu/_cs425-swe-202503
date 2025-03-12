package edu.miu.cs.cs425.citylibrarywebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping(value = {"", "/", "/home"})
    public String  displayHomepage() {
        return "index";
    }

}
