package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/user")
    public String showUser(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "user";
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String createUpdateForm(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "update";
    }

    @PostMapping("/user")
    public String updateUser(@RequestParam(value = "id") Long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
