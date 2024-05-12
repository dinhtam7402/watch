package com.elevengroup.watch.component;

import com.elevengroup.watch.entity.User;
import com.elevengroup.watch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setUserName("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setRole("ADMIN");

            userRepository.save(admin);
        }
        if (userRepository.count() == 1) {
            User staff = new User();
            staff.setUserName("staff");
            staff.setPassword(passwordEncoder.encode("123"));
            staff.setRole("USER");

            userRepository.save(staff);
        }
    }
}
