package com.cursojava.projetospring.resources;

import com.cursojava.projetospring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<User> findAll(){
    User u = new User((long) 1, "Maria", "Maria@gmail.com", "1235", "12345");
    return ResponseEntity.ok().body(u);
  }
}
