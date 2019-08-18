package com.breathe.breatheApi.repositories;

import com.breathe.breatheApi.BreatheApiApplicationTests;
import com.breathe.breatheApi.core.Admin;
import com.breathe.breatheApi.core.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
public class AdminRepositoryTest extends BreatheApiApplicationTests {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        User user = User.builder()
                .email("tow.sawyer@rush.edu")
                .fullName("Tom Sawyer")
                .build();

        Admin admin = Admin.builder()
                .user(user)
                .passwordHash("kjhgfdsa")
                .build();

        userRepository.save(user);
        Admin newAdmin = adminRepository.save(admin);
        assertNotNull(newAdmin.getId());

        Optional<Admin> optional = adminRepository.findById(newAdmin.getId());
        assertTrue(optional.isPresent());

        assertEquals(optional.get().getUser().getFullName(), "Tom Sawyer");
        assertEquals(optional.get().getPasswordHash(), "kjhgfdsa");
    }

    @Test
    public void testDelete() {
        User user = User.builder()
                .email("tow.sawyer@rush.edu")
                .fullName("Tom Sawyer")
                .build();

        Admin admin = Admin.builder()
                .user(user)
                .passwordHash("kjhgfdsa")
                .build();

        Long userId = userRepository.save(user).getId();
        Admin newAdmin = adminRepository.save(admin);
        Long id = newAdmin.getId();
        assertNotNull(newAdmin.getId());

        Optional<Admin> optional = adminRepository.findById(id);
        assertTrue(optional.isPresent());

        adminRepository.delete(newAdmin);
        optional = adminRepository.findById(id);
        assertFalse(optional.isPresent());

        Optional<User> oldUser = userRepository.findById(userId);
        assertTrue(oldUser.isPresent());
        assertEquals(oldUser.get().getFullName(), "Tom Sawyer");
    }
}