package com.example.MapTag.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwitterServiceImplTest {
    @Autowired
    TwitterService twitterService;

    @Test
    public void getTrends() throws Exception {
        twitterService.getTrends(1);
    }

}