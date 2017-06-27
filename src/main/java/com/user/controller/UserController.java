package com.user.controller;

import com.user.model.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aleksandr.tarasyuk on 25.06.2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.listUserd());
        return "Users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == null || user.getId() == 0L) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("users", userService.listUserd());

        return "Users";
    }

    @RequestMapping("/filter/edit/{id}")
    public String editInFilter(@PathVariable("id") Long id, Model model) {
        return editUser(id, model);
    }

    @RequestMapping("/filter/{type}")
    public String filterUsers(@PathVariable("type") String type, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.filteredUsers(type));

        return "Users";
    }

    @RequestMapping("/fill")
    public String fillUsers() {
        userService.fillUsers();

        return "redirect:/";
    }
}
