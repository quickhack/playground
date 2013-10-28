package com.oldratlee.groovy;

/**
 * @author ding.lid
 */
public class UseGroovyClassFromJava {
    public static void main(String[] args) {
        GroovyClass groovyObj = new GroovyClass();
        groovyObj.setName("Jerry");
        groovyObj.setValue(123);
        System.out.printf("Groovy Object: %s %s\n", groovyObj.getName(), groovyObj.getValue());
    }
}
