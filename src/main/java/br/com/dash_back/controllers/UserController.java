package br.com.dash_back.controllers;

import br.com.dash_back.entitys.User;
import br.com.dash_back.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Integer id){
        Optional<User> user;
        try {
            user = userRepository.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User newUser){
        return userRepository.findById(id)
                    .map(user -> {
                        user.setName(newUser.getName());
                        user.setAge(newUser.getAge());;
                        User userUpdate = userRepository.save(user);
                        return ResponseEntity.ok().body(userUpdate);
                    }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<User>> deleteById(@PathVariable Integer id){
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<Optional<User>>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
        }
    }

}
