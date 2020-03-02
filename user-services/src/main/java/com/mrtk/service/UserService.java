package com.mrtk.service;

import com.mrtk.model.User;
import com.mrtk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    public Long add(User user) {
        User persistedUser = userRepository.save(user);
        return persistedUser.getId();
    }

    public void delete(long id) {
        userRepository.delete(id);
    }
}
