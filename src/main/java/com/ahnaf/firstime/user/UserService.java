package com.ahnaf.firstime.user;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }

  public void deleteUser(ObjectId userId) {
    userRepository.deleteById(userId);
  }

  public void updateUser(ObjectId userId, User newUser) {
    var curUser = userRepository.findById(userId);
    if (curUser.isPresent()) {
      var user = curUser.get();
      user.setPassword(newUser.getPassword());
      userRepository.save(user);
    }
  }

  public User getUserById(ObjectId userId) {
    return userRepository.findById(userId).orElse(null);
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

}
