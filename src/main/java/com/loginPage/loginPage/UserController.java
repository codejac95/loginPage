package com.loginPage.loginPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder bCryptEncoder;
    
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
        String encryptedPassword = bCryptEncoder.encode(newPassword);
        user.setPassword(encryptedPassword);
        user.setFirstName(newfirstName);
        user.setLastName(newLastname);
        user.setMail(newMail);
        userRepository.save(user);
        return ("redirect:/");
    }
}