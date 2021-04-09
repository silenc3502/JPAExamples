package com.example.reqargs.controller;

import com.example.reqargs.controller.form.SignUpForm;
import com.example.reqargs.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainFormController {

    private final SignUpService signUpService;

    @PostMapping("/sign-up")
    public String signUp(@Valid SignUpForm form, BindingResult bindingResult) {
        log.debug("MainFormController#signUp: {}", form);
        if (bindingResult.hasFieldErrors()) {
            return "sign-up";
        }
        signUpService.signUp(form.toSignUpRequest());
        return "redirect:/";
    }
}
