package com.example.MapTag.model;

public class WoeidResponse {
    public static class Query {
        public Results results;
    }

    public static class Results {
        public Place place;
    }

    public static class Place {
        public String woeid;
    }
}
