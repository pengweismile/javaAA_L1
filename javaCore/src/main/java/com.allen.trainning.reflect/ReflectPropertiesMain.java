package com.allen.trainning.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectPropertiesMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        //所有"公有的"属性
        Class classObject = Class.forName("com.allen.trainning.reflect.Rstudent");
        Field[] fields = classObject.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("=====================================================================");

        //所有"公有的"属性
        Field[] pfields = classObject.getDeclaredFields();
        for (Field field : pfields) {
            System.out.println(field.getName());
        }
        System.out.println("=====================================================================");

        //获取，设置"非私有的"属性
        Rstudent student = (Rstudent) classObject.getConstructor(null).newInstance();
        Field name = classObject.getField("name");
        System.out.println(name.get(student));
        name.set(student, "little Bill");
        System.out.println(name.get(student));
        System.out.println("=====================================================================");

        //获取，设置"私有的"属性
        Field accountNumber = classObject.getDeclaredField("accountNumber");
        accountNumber.setAccessible(true);
        System.out.println(accountNumber.get(student));
        accountNumber.set(student, "888888888888");
        System.out.println(accountNumber.get(student));
        System.out.println("=====================================================================");
    }
}
