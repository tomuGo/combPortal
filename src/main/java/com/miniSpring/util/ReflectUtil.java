package com.miniSpring.util;

import java.lang.reflect.Field;

public class ReflectUtil {

    private static void setField(Field field,Object target,Object value) throws IllegalAccessException {
        field.set(target,value);
        field.setAccessible(Boolean.TRUE);
    }
}
