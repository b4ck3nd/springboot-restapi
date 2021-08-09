package api.controller;


import api.model.User;
import api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping()
    public List<User> findAllUsers() {

        userService.findAllUsers()
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id)  {

        Optional<User> user=userService.findUserById(id);

        if (user.isPresent()) {

            return ResponseEntity.ok().body(user.get());
        }
        else {
            ResponseEntity.notFound().build();
        }

    }


    @PostMapping
    public User saveUser(@Validated @RequestBody User user) {

        userService.saveUser(user);
    }
}
