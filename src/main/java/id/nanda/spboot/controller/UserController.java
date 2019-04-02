package id.nanda.spboot.controller;

import id.nanda.spboot.model.User;
import id.nanda.spboot.repository.UserMockedData;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return user;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String phoneNumber = body.get("phoneNumber");
        return userMockedData.addUser(id, name, phoneNumber);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable String id, @RequestBody Map<String, String> body) {
        int userId = Integer.parseInt(id);
        String name = body.get("name");
        String phoneNumber = body.get("phoneNumber");
        return userMockedData.updateUser(userId, name, phoneNumber);
    }

    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        return userMockedData.delete(userId);
    }
}
