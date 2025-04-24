package kz.sd.controller;

import kz.sd.model.User;
import kz.sd.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<User> getUser() {
        return service.getAllUsers();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUSer(@PathVariable Long id) {
        service.deleteUser(id);
    }
}