package com.example.LuongDinhBaoKhanh_2180605190_baiktra.Controllers.User;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Entities.Role;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Entities.User;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Services.RoleService;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAll());
        return "create-user";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable String id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "error-page";
        }
        List<Role> roles = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "edit-user";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable String id, @ModelAttribute User user) {
        user.setId(id);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.delete(id);
        return "redirect:/users";
    }
}