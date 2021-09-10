package com.movie.util;

import java.util.HashMap;

public class LocalUtils {
    private static HashMap<String, ThreadLocal<Object>> localhMap = new HashMap<>();

    public static void set(String key, Object value) {
        ThreadLocal<Object> local = localhMap.get(key);
        if (local == null) {
            local = new ThreadLocal<>();
            local.set(value);
            localhMap.put(key, local);
        } else {
            local.set(value);
        }
    }

    public static Object get(String key) {
        ThreadLocal<Object> local = localhMap.get(key);
        if (local == null) {
            return null;
        }
        return local.get();
    }
}
