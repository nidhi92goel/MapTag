package com.example.MapTag.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TwitterController {

        @GetMapping(value = "/")
        @ResponseBody
        java.lang.String home() {



            return "Hello World maptag!";
        }


}
