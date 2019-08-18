package com.breathe.breatheApi.repositories;

import com.breathe.breatheApi.BreatheApiApplicationTests;
import com.breathe.breatheApi.core.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;

public class UserRepositoryTest extends BreatheApiApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        User user = User.builder()
                .email("tow.sawyer@rush.edu")
                .fullName("Tom Sawyer")
                .build();

        User newUser = userRepository.save(user);
        assertNotNull(newUser.getId());

        Optional<User> optional = userRepository.findById(newUser.getId());
        assertTrue(optional.isPresent());

        assertEquals(optional.get().getFullName(), "Tom Sawyer");
    }

    @Test
    public void testUpdate() {
        User user = User.builder()
                .email("tow.sawyer@rush.edu")
                .fullName("Tom Sawyer")
                .build();

        User newUser = userRepository.save(user);
        assertNotNull(newUser.getId());

        newUser.setFullName("Tom Soyee");
        User updatedUser = userRepository.save(newUser);

        Optional<User> optional = userRepository.findById(updatedUser.getId());
        assertTrue(optional.isPresent());

        assertEquals(optional.get().getFullName(), "Tom Soyee");
        assertEquals(updatedUser.getId(), newUser.getId());
        assertEquals(optional.get().getId(), newUser.getId());
    }

    public void testDelete() {
        User user = User.builder()
                .email("tow.sawyer@rush.edu")
                .fullName("Tom Sawyer")
                .build();

        User newUser = userRepository.save(user);
        Long id = newUser.getId();
        assertNotNull(newUser.getId());

        Optional<User> optional = userRepository.findById(id);
        assertTrue(optional.isPresent());

        userRepository.delete(newUser);
        optional = userRepository.findById(id);
        assertFalse(optional.isPresent());
    }
}