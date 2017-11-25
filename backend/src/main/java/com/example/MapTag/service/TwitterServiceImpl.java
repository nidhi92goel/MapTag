package com.example.MapTag.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import twitter4j.*;

@Service
public class TwitterServiceImpl implements TwitterService {

    @Override
    public String[] getTrends(int id) {

        String[] hashtags=new String[10];
        Twitter twitter = new TwitterFactory().getInstance();

        Trends trends = null;
        try {
            trends = twitter.getPlaceTrends(id);


            for (int i = 0; i < 10; i++) {
                hashtags[i] = trends.getTrends()[i].getName();
                System.out.println(hashtags[i]);
            }

        } catch (TwitterException e) {
            e.printStackTrace();
        }



        return hashtags;

    }

    @Override
    public int getId(String place) {
        String url=String.format("https://query.yahooapis.com/v1/public/yql?q=select woeid from geo.places where text=\"%s\" limit 1&diagnostics=false&format=json", place);
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        WoeidResponse response = restTemplate.getForObject(url, WoeidResponse.class);

        String woeid = response.query.results.place.woeid;
        return Integer.parseInt(woeid);
    }
}


