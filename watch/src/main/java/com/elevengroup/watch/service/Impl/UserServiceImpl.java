package com.elevengroup.watch.service.Impl;

import com.elevengroup.watch.entity.User;
import com.elevengroup.watch.entity.UserDto;
import com.elevengroup.watch.repository.UserRepository;
import com.elevengroup.watch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        Random random = new Random();
        int randomNum = 1000 + random.nextInt(9000);
        User user = new User();
        user.setId("US" + randomNum);
        user.setUserName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole("USER");
        userRepository.save(user);
    }
}
