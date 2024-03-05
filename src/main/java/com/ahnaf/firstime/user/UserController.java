package com.ahnaf.firstime.user;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(value = "/")
  public void createUser(@RequestBody User user) {
    userService.saveUser(user);
  }

  @GetMapping("/all")
  public List<User> getAllUser() {
    return userService.getUsers();
  }

  @GetMapping("/{userId}")
  public ResponseEntity<User> getMethodName(@PathVariable ObjectId userId) {
    return ResponseEntity.ok().body(userService.getUserById(userId));
  }

  @PutMapping("/{userId}")
  public ResponseEntity<User> putMethodName(@PathVariable ObjectId userId, @RequestBody User newUser) {
    userService.updateUser(userId, newUser);
    return ResponseEntity.ok().body("User updated");
  }
}
