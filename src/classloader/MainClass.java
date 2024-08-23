package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        Class<?> aClass = Class.forName("classloader.Test");
        System.out.println(aClass.getClassLoader().getName());
        CustomClassLoaderDemo loader = new CustomClassLoaderDemo();
        Class<?> c = loader.findClass("classloader.Test");
        System.out.println(c.getClassLoader().getName());

        System.out.println(aClass == c);
        Test o1 = (Test) aClass.newInstance();
        o1.show();
        Object ob = c.newInstance();
        Method md = c.getMethod("show");

        md.invoke(ob);
    }
}