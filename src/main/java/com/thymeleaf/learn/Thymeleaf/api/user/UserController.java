package com.thymeleaf.learn.Thymeleaf.api.user;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;
import com.thymeleaf.learn.Thymeleaf.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "users/list";
    }

}
