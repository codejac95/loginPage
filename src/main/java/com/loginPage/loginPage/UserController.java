package com.loginPage.loginPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    
   @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username")String newUsername,
                               @RequestParam("password")String newPassword,
                               @RequestParam("firstName")String newfirstName,
                               @RequestParam("lastName")String newLastname,
                               @RequestParam("mail")String newMail) {
        User user = new User();
        user.setUsername(newUsername);
        user.setPassword(newPassword);
        user.setFirstName(newfirstName);
        user.setLastName(newLastname);
        user.setMail(newMail);
        userRepository.save(user);
        return ("redirect:/");
    }
    
}
