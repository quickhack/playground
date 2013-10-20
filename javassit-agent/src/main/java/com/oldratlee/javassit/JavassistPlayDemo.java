package com.oldratlee.javassit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Method;

/**
 * @author ding.lid
 */
public class JavassistPlayDemo {
    public static void main(String[] args) throws Exception {
        Class[] classes = {Son.class, Base.class, Foo.class,};


        for (Class cls : classes) {
            System.out.println("=================================================");
            CtClass clazz = ClassPool.getDefault().get(cls.getName());
            CtMethod[] methods = clazz.getMethods();
            for (CtMethod method : methods) {
                System.out.printf("%s of %s\n", method, method.getDeclaringClass().getName());
            }

            System.out.println("--------------------------------------------------");
            for (Method method : cls.getMethods()) {
                System.out.printf("%s of %s\n", method, method.getDeclaringClass().getName());
            }
        }
    }
}
