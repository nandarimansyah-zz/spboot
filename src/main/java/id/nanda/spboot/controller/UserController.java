package id.nanda.spboot.controller;

import id.nanda.spboot.model.User;
import id.nanda.spboot.repository.UserMockedData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserMockedData userMockedData = UserMockedData.getInstance();

    @RequestMapping("/")
    public String index() {
        return "Congratulations from UserController.java";
    }

    @GetMapping("/user")
    public List<User> fetchAll() {
        return userMockedData.fetchUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        User user = userMockedData.getUserById(userId);
        System.out.println("User is " + user);
        return user;
    }
}
