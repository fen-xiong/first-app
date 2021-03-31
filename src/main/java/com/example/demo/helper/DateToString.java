package com.example.demo.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface DateToString {
    default String getCurrentTime() {
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return  df2.format(new Date());
    }
}

