package com.adocao.gpms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String showTest(Model model) {
        model.addAttribute("teste", "mensagem  de teste");

        return "test";
    }
}
