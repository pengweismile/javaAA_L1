package com.allen.trainning.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class ReflectConstructorMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        //反射就是把java类中的各种成分映射成一个个的Java对象
        System.out.println(Rstudent.class == Class.forName("com.allen.trainning.reflect.Rstudent"));
        System.out.println(Rstudent.class == new Rstudent("").getClass());
        System.out.println("=====================================================================");

        //所有"公有的"构造方法
        Class classObject = Class.forName("com.allen.trainning.reflect.Rstudent");
        Constructor[] constructors = classObject.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("public only -- " + constructor);
        }
        System.out.println("=====================================================================");

        //获取所有的构造方法(包括私有)
        Constructor[] pconstructors = classObject.getDeclaredConstructors();
        for (Constructor constructor : pconstructors) {
            System.out.println("all constructors -- " + constructor);
        }
        System.out.println("=====================================================================");

        //获取单个公的方法，并调用
        Constructor sconstructor = classObject.getConstructor(String.class);
        Rstudent student = (Rstudent) sconstructor.newInstance("Allen");
        System.out.println("got student -- " + student.name);
        System.out.println("=====================================================================");

        //获取单个的私有构造方法，并调用
        Constructor psconstructor = classObject.getDeclaredConstructor(BigDecimal.class);
        psconstructor.setAccessible(true);
        Rstudent pstudent = (Rstudent) psconstructor.newInstance(new BigDecimal("90000000.989"));
        System.out.println("got money -- " + pstudent.money);
    }
}
