package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {


    @Controller
    class HelloController {

        @GetMapping("/")
        @ResponseBody
        public String hello() {
            return "This is the landing page!";
        }
    }
}
