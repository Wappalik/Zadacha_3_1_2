package com.wappalik.Zadacha_3_1_2.controller;


import com.wappalik.Zadacha_3_1_2.model.User;
import com.wappalik.Zadacha_3_1_2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/")
    public String sayHello(Model model) {
        List<User> userList = service.getAllUsers();
        model.addAttribute("users", userList);
        return "all-users";
    }

    @GetMapping("/addNewEmployee")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-info";
        } else {
            service.saveUser(user);
            return "redirect:/";
        }
    }

    @PatchMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model) {

        User user = service.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }
    @DeleteMapping ("/deleteInfo")
    public String deleteUser (@RequestParam ("userId") int id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }
}


