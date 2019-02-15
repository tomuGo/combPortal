package com.miniSpring.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestPath {
    String value() default "";
    String methed() default "GET";
}