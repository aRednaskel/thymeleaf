package com.thymeleaf.learn.Thymeleaf.api.user;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;
import com.thymeleaf.learn.Thymeleaf.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "users/form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") long userId, Model model) {

        User user = userService.findById(userId);

        model.addAttribute("user", user);

        return "users/form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") long userId) {
        userService.deleteById(userId);
        return "redirect:/users/list";
    }

    @GetMapping("/search")
    public String delete(@RequestParam("name") String name, Model model) {
        List<User> users = userService.findByName(name);

        model.addAttribute("users", users);

        return "/users/list";

    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/users/list";
    }

}
