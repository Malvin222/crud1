package com.crud1.crud1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud1.crud1.dto.UserDTO;
import com.crud1.crud1.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @GetMapping("/register")
    public void userRegiseterGet(){
        log.info("=====GET user register======");
    }

    @PostMapping("/register")
    public String userRegisterPost(UserDTO userDTO){

        log.info("=====POST user register=====");
        
        userService.register(userDTO);

        return "redirect:/user/register";
    }

}
