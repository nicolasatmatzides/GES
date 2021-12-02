package com.adocao.gpms.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloApiController {


    @GetMapping("/")
    public ResponseEntity getInitialMessage() {
        return ResponseEntity.ok().body("<h1>Home</h1>");
    }
    @GetMapping("/user")
    public ResponseEntity getUserMessage() {
        return ResponseEntity.ok().body("<h1>Hello User</h1>");
    }


}
