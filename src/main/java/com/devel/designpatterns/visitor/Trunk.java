package com.devel.designpatterns.visitor;

public class Trunk implements CarPart {

    @Override
    public void accept(CarVisitor visitor) {
        visitor.visit(this);
    }
}
