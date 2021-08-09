package api.service;

import api.model.User;
import api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {

        return  userRepository.findAll();
    }

    public User findUserById(long id) {

        return userRepository.findAllById(id);
    }


    public User saveUser(User user) {

        return userRepository.saveAndFlush(user);
    }




}
