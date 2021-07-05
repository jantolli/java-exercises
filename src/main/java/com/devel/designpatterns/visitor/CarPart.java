package com.devel.designpatterns.visitor;

public interface CarPart {

    public void accept(CarVisitor visitor);
}
