package com.tnsif.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerExample {

    @RequestMapping("/helloCoders")
    public String show() {
        return "Welcome to the TNSIF Capgemini CSR Spring boot session";
    }

    @GetMapping("/hello")
    public String greetings(@RequestParam String name) {
        return "Welcome " + name;
    }

    @GetMapping("/hello/{name}")
    public String message(@PathVariable String name) {
        return "Welcome " + name;
    }
}