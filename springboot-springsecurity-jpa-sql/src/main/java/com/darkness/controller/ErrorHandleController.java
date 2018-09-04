package com.darkness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandleController {
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
