package com.devel.designpatterns.visitor;


/**
 * Visitor class to print a different message based on each element type
 */
public class CarPartDisplayCarVisitor implements CarVisitor {

    @Override
    public void visit(Door part) {
        System.out.println("This is a door");
    }

    @Override
    public void visit(Trunk part) {
        System.out.println("This is a trunk");
    }

    @Override
    public void visit(Wheel part) {
        System.out.println("This is a wheel");
    }
}
