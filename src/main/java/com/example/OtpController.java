package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OtpController {

    @Autowired
    private UserService userService;

    @GetMapping("/verify")
    public String showOtpVerificationForm(Model model) {
        model.addAttribute("verificationForm", new VerificationForm());
        return "verification";
    }

    @PostMapping("/verify")
    public String verifyOtp(@ModelAttribute("verificationForm") VerificationForm verificationForm) {
        String email = verificationForm.getEmail();
        String otp = verificationForm.getOtp();
        
        User user = userService.findByEmail(email);
        
        if (user != null && user.getOtp().equals(otp)) {
            // Successful verification, you can log in or perform further actions
            return "verification-success";
        } else {
            // Failed verification
            return "verification-fail";
        }
    }
}
