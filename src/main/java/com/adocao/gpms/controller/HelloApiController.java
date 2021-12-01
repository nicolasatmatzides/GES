package com.adocao.gpms.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {


    @GetMapping("/")
    public ResponseEntity initialMessage() {
        return ResponseEntity.ok().body("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public ResponseEntity getUserMessage() {
        return ResponseEntity.ok().body("<h1>Hello User</h1>");
    }


}
