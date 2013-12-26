package com.oldratlee.groovy.java;

import com.oldratlee.groovy.GroovyHello;

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
