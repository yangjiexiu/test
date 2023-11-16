package com.lms.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {


    @GetMapping(value = "/login")
    public String showLoginPage(Model model,@RequestParam(value = "error",defaultValue = "false") boolean error) {
        model.addAttribute("failure", error);
        return "login";
    }


}
