package com.devel.designpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class Automobile implements CarPart {

    List<CarPart> automobile = null;

    public Automobile() {
        automobile = new ArrayList<>();
        automobile.add(new Door());
        automobile.add(new Trunk());
        automobile.add(new Wheel());
    }

    @Override
    public void accept(CarVisitor visitor) {
        for (CarPart part: automobile) {
            part.accept(visitor);
        }
    }
}
