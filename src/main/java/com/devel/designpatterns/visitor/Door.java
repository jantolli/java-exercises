package com.devel.designpatterns.visitor;

public class Door implements CarPart {

    @Override
    public void accept(CarVisitor visitor) {
        visitor.visit(this);
    }
}
