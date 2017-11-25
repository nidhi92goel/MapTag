package com.example.MapTag.controllers;

import com.example.MapTag.service.TwitterService;
import com.example.MapTag.service.TwitterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class TwitterController {

    @Autowired
    TwitterService twitterService;

    @GetMapping(value = "/")
    @ResponseBody
    ArrayList<String> home(@RequestParam("place") String place) {

        int id=twitterService.getId(place);
        System.out.println(String.format("ID is %d", id));
        return twitterService.getTrends(id);
    }
}
