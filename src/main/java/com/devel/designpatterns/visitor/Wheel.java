package com.devel.designpatterns.visitor;

public class Wheel implements CarPart {

    @Override
    public void accept(CarVisitor visitor) {
        visitor.visit(this);
    }
}
