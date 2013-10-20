package com.oldratlee.javassit;

/**
 * @author ding.lid
 */
public class JavassistAgentDemo {
    public static void main(String[] args) {
        Son s = new Son();
        Base b = new Base();

        b.hello();
        b.world();

        s.hello();
        s.world();
    }
}
