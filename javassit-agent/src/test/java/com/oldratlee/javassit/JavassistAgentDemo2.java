package com.oldratlee.javassit;

/**
 * @author ding.lid
 */
public class JavassistAgentDemo2 {
    public static void main(String[] args) {
        Base b = new Base();
        Son s = new Son(); // Exception: com.oldratlee.javassit.Base class is frozen!

        b.hello();
        b.world();

        s.hello();
        s.world();
    }
}
