package com.example.LuongDinhBaoKhanh_2180605190_baiktra.Services;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Entities.Role;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public void delete(String id) {
        roleRepository.deleteById(id);
    }
}
