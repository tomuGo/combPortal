package com.miniSpring.ioc;

import com.miniSpring.core.BeanContainer;
import com.miniSpring.ioc.annotations.Autowired;

import java.lang.reflect.Field;
import java.util.Set;

public class Ioc {

    private BeanContainer beanContainer;

    public Ioc(){
        beanContainer=BeanContainer.getInstance();
    }

    public void doIoc(){
        Set<Class<?>>classSets= beanContainer.getClasses();
        for(Class<?>clazz:classSets){
            Object target=beanContainer.getObject(clazz);
            Field[]fields=clazz.getFields();
            for(Field field:fields){
                //注入属性
                if(field.isAnnotationPresent(Autowired.class)){
                    field.setAccessible(Boolean.TRUE);
                    try {
                        field.set(target,beanContainer.getObject(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("注入失败:"+e);
                    }
                }
            }

        }
    }


}
