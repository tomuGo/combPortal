package com.miniSpring.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author wangyiming1031@aliyun.com
 * @Description 包扫描
 * @Date 2019/2/16 22:13
 **/
@Slf4j
public class ClassScanner {

    public static Set<Class<?>> scanPackage(String pkg) throws IOException {
        Set<Class<?>> classes = new LinkedHashSet<>();

        String pkgDirName = pkg.replace('.', '/');
        Enumeration<URL> urls = ClassScanner.class.getClassLoader().getResources(pkgDirName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String filePath = URLDecoder.decode(url.getFile(), "UTF-8");// 获取包的物理路径
            findClassesByFile(pkg, filePath, classes);
        }
        return classes;
    }

    private static void findClassesByFile(String pkgName, String pkgPath, Set<Class<?>> classes) {
        File dir = new File(pkgPath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 过滤获取目录，or class文件
        File[] dirfiles = dir.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith("class"));
        if (dirfiles == null || dirfiles.length == 0) {
            return;
        }
        String className;
        Class clz;
        for (File f : dirfiles) {
            if (f.isDirectory()) {
                findClassesByFile(pkgName + "." + f.getName(), pkgPath + "/" + f.getName(), classes);
                continue;
            }
            // 获取类名，干掉 ".class" 后缀
            className = f.getName();
            className = className.substring(0, className.length() - 6);

            // 加载类
            clz = loadClass(pkgName + "." + className);
            if (clz != null) {
                classes.add(clz);
            }
        }
    }

    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error", e);
            throw new RuntimeException("获取类文件异常");
        }
    }

    public static Object getClassInstance(Class<?> clazz) {
        try {
            return clazz.getClass().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化类出错");
        }
    }

    public static void main(String[] args) throws IOException {
        Set<Class<?>> classes = scanPackage("com.comb");
        System.out.println(classes.toString());
    }


}
