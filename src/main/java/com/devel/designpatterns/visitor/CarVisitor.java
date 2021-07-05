package com.devel.designpatterns.visitor;

public interface CarVisitor {

    public void visit(Door part);

    public void visit(Trunk part);

    public void visit(Wheel part);
}
