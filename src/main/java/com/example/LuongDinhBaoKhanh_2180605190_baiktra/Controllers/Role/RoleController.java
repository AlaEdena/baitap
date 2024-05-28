package com.example.LuongDinhBaoKhanh_2180605190_baiktra.Controllers.Role;

import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Entities.Role;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String getAllRoles(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "roles";
    }

    @GetMapping("/create")
    public String createRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "create-role";
    }

    @PostMapping("/create")
    public String createRole(@ModelAttribute Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String editRoleForm(@PathVariable String id, Model model) {
        Role role = roleService.findById(id);
        if (role == null) {
            return "error-page";
        }
        model.addAttribute("role", role);
        return "edit-role";
    }

    @PostMapping("/edit/{id}")
    public String editRole(@PathVariable String id, @ModelAttribute Role role) {
        role.setRole_id(id);
        roleService.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable String id) {
        roleService.delete(id);
        return "redirect:/roles";
    }
}
