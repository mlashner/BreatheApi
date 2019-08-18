package com.breathe.breatheApi.services;

import com.breathe.breatheApi.core.Admin;
import com.breathe.breatheApi.core.User;
import com.breathe.breatheApi.repositories.AdminRepository;
import com.breathe.breatheApi.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Admin.class, "Admin not found for id :: " + id));
    }

    public Admin createAdmin(Admin admin) {
        // TODO: check if admin exists before creating admin
        return adminRepository.save(admin);
    }

    public Admin checkUserIsAdmin(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException(Admin.class, "Admin not found for id :: " + userId));
        return user.getAdmin();
    }

    public void deleteAdmin(Long id) {
        adminRepository.delete(findById(id));
    }
}
