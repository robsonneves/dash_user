package br.com.dash_back.controllers;

import br.com.dash_back.entitys.User;
import br.com.dash_back.repositorys.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "HELLO WORD";
    }

}
