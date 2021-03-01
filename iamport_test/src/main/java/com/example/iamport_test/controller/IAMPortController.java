package com.example.iamport_test.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log
@Controller
public class IAMPortController {

    @GetMapping("/test")
    public String iamportTest() {
        log.info("iamportTest()");

        return "iamport";
    }

    @GetMapping("/user/mypage/charge/point")
    public void chargePoint(Long amount) {
        System.out.println(amount);
    }
}
