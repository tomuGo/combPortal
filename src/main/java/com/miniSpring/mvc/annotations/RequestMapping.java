package com.miniSpring.mvc.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String value() default "";

    RequestMethed methed() default RequestMethed.GET;
}
