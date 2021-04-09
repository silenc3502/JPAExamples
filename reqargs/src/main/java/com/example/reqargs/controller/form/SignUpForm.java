package com.example.reqargs.controller.form;

import com.example.reqargs.service.SignUpRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignUpForm {

    @Email(message = "잘못된 이메일입니다.")
    @NotEmpty(message = "이메일은 필수입니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;

    public SignUpRequest toSignUpRequest() {
        return new SignUpRequest(email, password);
    }
}
