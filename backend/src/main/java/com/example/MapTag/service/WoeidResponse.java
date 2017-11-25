package com.example.MapTag.service;

public class WoeidResponse {

    public Query query;

    public static class Query {
        public Results results;

        public Results getResults() {
            return results;
        }

        public void setResults(Results results) {
            this.results = results;
        }
    }

    public static class Results {
        public Place place;

        public Place getPlace() {
            return place;
        }

        public void setPlace(Place place) {
            this.place = place;
        }
    }

    public static class Place {
        public String woeid;

        public String getWoeid() {
            return woeid;
        }

        public void setWoeid(String woeid) {
            this.woeid = woeid;
        }
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}



