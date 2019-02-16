package com.miniSpring.model;

import java.lang.reflect.Method;
import java.util.HashMap;

public class HandlerMap {

    private static final HashMap<String, Method> handlerMapping = new HashMap<>(20);

    private static Method getMethod(String key) {
        return handlerMapping.get(key);
    }

    private static void setMethod(String key, Method method) {
        handlerMapping.put(key, method);
    }
}
