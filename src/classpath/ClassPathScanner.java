package classpath;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassPathScanner {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?>[] tests = getClasses("test");
        System.out.println(tests);

    }
    public static Class<?>[] getClasses(String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();

        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources;

        try {
            resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File directory = new File(resource.getFile());

                if (directory.exists() && directory.isDirectory()) {
                    File[] files = directory.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            classes.addAll(findClasses(file, packageName));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes.toArray(new Class[0]);
    }

    private static List<Class<?>> findClasses(File file, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();

        String fileName = file.getName();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File nestedFile : files) {
                    classes.addAll(findClasses(nestedFile, packageName + "." + fileName));
                }
            }
        } else if (fileName.endsWith(".class")) {
            String className = packageName + '.' + fileName.substring(0, fileName.length() - 6);
            Class<?> clazz = Class.forName(className);
            classes.add(clazz);
        }

        return classes;
    }
}

