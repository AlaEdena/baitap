package com.example.LuongDinhBaoKhanh_2180605190_baiktra.Services;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Entities.User;
import com.example.LuongDinhBaoKhanh_2180605190_baiktra.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

}
