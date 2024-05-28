package com.example.LuongDinhBaoKhanh_2180605190_baiktra.Controllers.Role;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Entities.Role;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAll();
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable String id) {
        Role role = roleService.findById(id);
        if (role == null) {
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.save(role);
        return new ResponseEntity<Role>(createdRole, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable String id, @RequestBody Role role) {
        // Chuyển đổi id từ String sang Long nếu cần
        Long roleId = Long.parseLong(id);
        Role existingRole = roleService.findById(String.valueOf(roleId));
        if (existingRole == null) {
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
        // Không cần gán giá trị ID ở đây
        Role updatedRole = roleService.save(role);
        return new ResponseEntity<Role>(updatedRole, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable String id) {
        Role existingRole = roleService.findById(id);
        if (existingRole == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        roleService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
