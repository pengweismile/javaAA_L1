package com.allen.trainning.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethodMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        //所有"公有的"方法，包括父类的，父接口的
        Class classObject = Class.forName("com.allen.trainning.reflect.Rstudent");
        Method[] methods = classObject.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("=====================================================================");

        //所有"本类"方法，包括私有的
        Method[] pmethods = classObject.getDeclaredMethods();
        for (Method method : pmethods) {
            System.out.println(method);
        }
        System.out.println("=====================================================================");

        //获取，调用所有类型的方法
        Rstudent student = (Rstudent) classObject.getConstructor(null).newInstance(null);
        Method nameMethod = classObject.getMethod("printName", null);
        nameMethod.invoke(student, null);

        Method printAcctMethod = classObject.getDeclaredMethod("printAccountNumber", null);
        printAcctMethod.setAccessible(true);
        printAcctMethod.invoke(student, null);

        Method setAcctMethod = classObject.getDeclaredMethod("setAccountNumber", String.class);
        setAcctMethod.setAccessible(true);
        setAcctMethod.invoke(student, "999999999999");

        printAcctMethod.invoke(student, null);
        System.out.println("=====================================================================");

    }
}
