package com.example.MapTag.service;

import org.springframework.stereotype.Service;
import twitter4j.*;

@Service
public class TwitterServiceImpl implements TwitterService {

    @Override
    public void getTrends(int id) {


        Twitter twitter = new TwitterFactory().getInstance();

        Trends trends = null;
        try {
            trends = twitter.getPlaceTrends(id);

            for (int i = 0; i < 10; i++) {
                System.out.println(trends.getTrends()[i].getName());
            }

        } catch (TwitterException e) {
            e.printStackTrace();
        }



    }
}


