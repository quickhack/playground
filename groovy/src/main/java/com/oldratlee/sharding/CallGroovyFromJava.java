package com.oldratlee.sharding;

/**
 * @author ding.lid
 */
public class CallGroovyFromJava {
    public static void main(String[] args) {
        GroovyHello.main(args);
        
        GroovyHello hello = new GroovyHello();
        hello.run();
        
        GroovyClass groovyObj = new GroovyClass();
        groovyObj.setName("Jerry");
        groovyObj.setValue(123);
        System.out.printf("Groovy Object: %s %s\n", groovyObj.getName(), groovyObj.getValue());
    }
}
