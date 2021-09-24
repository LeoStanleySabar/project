package com.skillmine.service;

import com.skillmine.domain.User;
import com.skillmine.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("user@gmail.com","user","password"));
        users.add(new User("user2@gmail.com","user2","password"));
    }

    public void saveInitialBatch(){
        userRepository.saveAll(users);
    }
    
    public User getUser(String email) {
    	
    	return userRepository.findByEmail(email);
    }

}
