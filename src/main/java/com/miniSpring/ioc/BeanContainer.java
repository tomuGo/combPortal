package com.miniSpring.ioc;

import com.miniSpring.mvc.annotations.Component;
import com.miniSpring.mvc.annotations.Controller;
import com.miniSpring.mvc.annotations.Service;
import com.miniSpring.util.ClassScanner;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;

public class BeanContainer {

    /**
     * IOC容器
     */
    private final Map<Class<?>, Object> beanMap = new HashMap<>();

    private static List<Class<? extends Annotation>> ANNOTATION_LIST = Arrays.asList(Controller.class, Service.class, Component.class);

    private BeanContainer getInstance() {
        return ContainerHolder.holder.instance;
    }

    /**
     * 容器注入Controller,Service,Component修饰的实例
     */
    private void loadAnnotations(String packagePath) throws IOException {
        Set<Class<?>> classSet = ClassScanner.scanPackage(packagePath);
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : ANNOTATION_LIST) {
                if (clazz.isAnnotationPresent(annotation)) {
                    beanMap.put(clazz, ClassScanner.getClassInstance(clazz));
                }
            }
        }
    }

    private enum ContainerHolder {
        holder,;
        private BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }


}
