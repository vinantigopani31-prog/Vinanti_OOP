package apack;

public class A {
    public int pubVar;
    protected int protVar;
    private int privVar;
    // Constructor
    public A(int a, int b, int c) {
        pubVar = a;
        protVar = b;
        privVar = c;
    }
    // Method to access private variable inside same class
    public void showPrivate() {
        System.out.println("Private Variable (inside A): " + privVar);
    }
}
package bpack;

import apack.A;
public class B extends A {

    public B(int a, int b, int c) {
        super(a, b, c);
    }
    public void display() {
        System.out.println("Inside Class B (Subclass)");

        // Accessible
        System.out.println("Public Variable: " + pubVar);
        System.out.println("Protected Variable: " + protVar);

        // Not Accessible
        // System.out.println("Private Variable: " + privVar); // ERROR

        // Access private via method
        showPrivate();
    }
}
package cpack;

import apack.A;

public class C {

    public void display() {
        A obj = new A(10, 20, 30);

        System.out.println("Inside Class C (Non-Subclass)");

        // Accessible
        System.out.println("Public Variable: " + obj.pubVar);

        // Not Accessible
        // System.out.println("Protected Variable: " + obj.protVar); // ERROR
        // System.out.println("Private Variable: " + obj.privVar);   // ERROR

        // Access private via public method
        obj.showPrivate();
    }
}
package dpack;
import bpack.B;
import cpack.C;
public class ProtectedDemo {
    public static void main(String[] args) {

        B objB = new B(1, 2, 3);
        C objC = new C();

        System.out.println("----- Access from B (Subclass) -----");
        objB.display();

        System.out.println("\n----- Access from C (Non-Subclass) -----");
        objC.display();
    }
}
