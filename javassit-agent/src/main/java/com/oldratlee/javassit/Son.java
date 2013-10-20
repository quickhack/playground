package com.oldratlee.javassit;

/**
 * @author ding.lid
 */
public class Son extends Base {
    @Override
    public void hello() {
        System.out.println("Son.hello");
    }

    public void bye() {
        System.out.println("Son.bye");
    }

    void defaultMethodInBase() {
    }

    protected void protectedMethodInBase() {
    }


    private void privateMethod() {
    }

    void defaultMethod() {
    }

    protected void protectedMethod() {
    }

}
