package com.example.MapTag.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import twitter4j.*;

import java.util.ArrayList;

@Service
public class TwitterServiceImpl implements TwitterService {


    @Override
    public ArrayList<String> getTrends(int id) {

        ArrayList<String> hashtags = new ArrayList<>();

        if(id==0)
            return hashtags;

        Twitter twitter = new TwitterFactory().getInstance();

        Trends trends = null;
        try {
            trends = twitter.getPlaceTrends(id);

            String temp;
            int i = 0;
            while (hashtags.size() < 10) {
                hashtags.add(trends.getTrends()[i].getName());
                i++;
            }


        } catch (TwitterException e) {
            e.printStackTrace();
        }


        return hashtags;

    }

    @Override
    public int getId(String place) {
        String url = String.format("https://query.yahooapis.com/v1/public/yql?q=select woeid from geo.places where text=\"%s\" limit 1&diagnostics=false&format=json", place);
        RestTemplate restTemplate = new RestTemplate();
        try {
            WoeidResponse response = restTemplate.getForObject(url, WoeidResponse.class);
            String woeid = response.query.results.place.woeid;
            return Integer.parseInt(woeid);
        } catch(NullPointerException e){
            return 0;
        }
    }
}


