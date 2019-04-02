package id.nanda.spboot.repository;

import id.nanda.spboot.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMockedData {
    private List<User> users;

    private static UserMockedData instance = null;
    public static UserMockedData getInstance(){
        if(instance == null){
            instance = new UserMockedData();
        }
        return instance;
    }

    public UserMockedData() {
        users = new ArrayList<>();
        users.add(new User(1, "nanda", "081212345678"));
        users.add(new User(2, "rifky", "081512345678"));
        users.add(new User(3, "mawaddi", "081812345678"));
    }

    public List<User> fetchUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User addUser(int id, String name, String phoneNumber) {
        User newUser = new User(id, name, phoneNumber);
        users.add(newUser);
        return newUser;
    }

    public User updateUser(int id, String name, String phoneNumber) {
        User user = getUserById(id);
        if (user != null) {
            int userIndex = users.indexOf(user);

            user.setName(name);
            user.setPhoneNumber(phoneNumber);

            users.set(userIndex, user);
            return user;
        }
        return null;
    }

    public boolean delete(int id){
        User user = getUserById(id);
        if (user != null) {
            return users.remove(user);
        }
        return false;
    }
}
