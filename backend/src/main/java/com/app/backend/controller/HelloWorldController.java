package com.app.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("api/hello-world")
public class HelloWorldController {

    @GetMapping
    public String helloWordFromBackend() {
        return "Backend response";
    }
}
