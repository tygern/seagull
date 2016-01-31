package com.tygern.seagull.birdfoodapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BirdfoodController {
    @RequestMapping("/birdfood")
    public String birdfood() {
        return "seed";
    }
}
