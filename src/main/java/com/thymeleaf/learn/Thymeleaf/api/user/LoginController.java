package com.thymeleaf.learn.Thymeleaf.api.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/loginPage")
    public String showMyLoginPage() {

        return "login/login";

    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "login/access-denied";

    }
}
