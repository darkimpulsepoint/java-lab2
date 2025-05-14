package org.darkimpulsepoint.circles.specification.impl;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.specification.Specification;

public class UnitCircleSpecification implements Specification<Circle> {

    @Override
    public boolean isSatisfiedBy(Circle circle){
        return circle.getRadius() == 1;
    }
}
