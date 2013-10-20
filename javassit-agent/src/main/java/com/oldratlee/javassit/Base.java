package com.oldratlee.javassit;

/**
 * @author ding.lid
 */
public class Base implements Foo {
    @Override
    public void hello() {
        System.out.println("Base.hello");
    }

    public void world() {
        System.out.println("Base.world");
    }

    private void privateMethodInBase() {
    }

    void defaultMethodInBase() {
    }

    protected void protectedMethodInBase() {
    }
}
