package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OtpService otpService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        String otp = otpService.generateOtp();
        user.setOtp(otp);
        userService.save(user);
        otpService.sendOtpEmail(user.getEmail(), otp);
        return "redirect:/verify";
    }
}
