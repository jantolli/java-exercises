package com.devel.designpatterns.visitor;

public class TestVisitorPattern {

    public static void main(String[] args) {

        Automobile automobile = new Automobile();

        // This accepts a visitor an loops through each one of the parts calling its corresponding visitor implementation
        automobile.accept(new CarPartDisplayCarVisitor());

    }

}
