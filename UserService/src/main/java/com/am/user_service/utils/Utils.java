package com.am.user_service.utils;

public class Utils {
    public static <T> T nvl (T value, T defaultValue){
        return value != null ? value : defaultValue;
    }

}
