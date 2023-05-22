package com.java.functional.interfaces;

interface I{
    void m(String s);
}

public class BasicLambdas {
    public static void main(String[] args) {
        I i = new I() {
            @Override
            public void m(String s) {
                System.out.println("old way: " + s);
            }
        };
        i.m("Hello World!");

        I i1 = (s) -> {
            System.out.println("new way - 1: " + s);
        };
        i1.m("Hello World!");

        I i2 = (s) -> System.out.println("new way - 2: " + s);
        i2.m("Hello World!");

        I i3 = System.out::println;
        i3.m("Hello World!");

    }

}
