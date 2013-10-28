package com.oldratlee.groovy;

/**
 * @author ding.lid
 */
public class CallGroovyScriptFromJava {
    public static void main(String[] args) {
        GroovyHello.main(args);

        GroovyHello hello = new GroovyHello();
        hello.run();
    }
}
