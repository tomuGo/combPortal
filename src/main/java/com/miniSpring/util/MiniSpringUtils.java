package com.miniSpring.util;

import com.comb.web.CombController;
import com.miniSpring.ConfigProperities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class MiniSpringUtils {

    public static ConfigProperities readProperties(String path) throws IOException {
        File file = new File(path);
        FileInputStream in = new FileInputStream(file);
        ConfigProperities config = new ConfigProperities();
        config.load(in);
        String port = config.getProperty("port");
        config.setPort(port == null ? 12345 : Integer.valueOf(port));
        String enableLog = config.getProperty("enableLog");
        config.setEnableLog(enableLog == null ? Boolean.FALSE : Boolean.valueOf(enableLog));
        config.setLogPath(config.getProperty("logPath"));
        return config;
    }

    public static void main(String[] args) throws IOException {
        ConfigProperities configProperities = readProperties("src/main/resources/application.yml");
        System.out.println(configProperities.toString());
    }

    public static void readAnnotation(){
        Class<CombController> clazz = CombController.class;
        Method[] methods=clazz.getDeclaredMethods();
        for(Method method:methods){
            /*RequestPath requestPath=method.getAnnotation(RequestPath.class);
            if(requestPath!=null){
                System.out.println(method.getName());
            }*/
        }
        System.out.println(methods.toString());
    }
}
