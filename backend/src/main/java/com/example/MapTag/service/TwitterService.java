package com.example.MapTag.service;

import java.util.ArrayList;

public interface TwitterService {

    ArrayList<String> getTrends(int id);

    int getId(String place);


}
