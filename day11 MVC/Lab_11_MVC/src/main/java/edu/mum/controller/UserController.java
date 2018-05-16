package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.domain.User;
import edu.mum.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping({"", "all"})
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/{id}")
    public String getUserById(Model model, @PathVariable("id") Long id) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewUserForm(@ModelAttribute("newUser") User newUser) {
        return "addUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewUserForm(@ModelAttribute("newUser") @Valid User userToBeAdded, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        }

        try {
            userService.save(userToBeAdded);
        } catch (Exception ex) {
            System.out.println("AddUser Transaction Failed");
        }
        return "redirect:/users";
    }

}
