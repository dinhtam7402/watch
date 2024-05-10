package com.elevengroup.watch.component;

import com.elevengroup.watch.entity.Customer;
import com.elevengroup.watch.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    CustomersRepository customersRepository;

    @Override
    public void run(String... args) throws Exception {
        if (customersRepository.count() == 0) {
            Customer admin = new Customer();
            admin.setUserName("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setRole("ADMIN");

            customersRepository.save(admin);
        }
        if (customersRepository.count() == 1) {
            Customer staff = new Customer();
            staff.setUserName("staff");
            staff.setPassword(passwordEncoder.encode("123"));
            staff.setRole("USER");

            customersRepository.save(staff);
        }
    }
}
