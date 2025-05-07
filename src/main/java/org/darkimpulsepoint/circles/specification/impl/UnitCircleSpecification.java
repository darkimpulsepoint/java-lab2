package org.darkimpulsepoint.circles.specification.impl;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.service.CircleService;
import org.darkimpulsepoint.circles.specification.Specification;

public class UnitCircleSpecification implements Specification<Circle> {
    private CircleService circleService;

    public UnitCircleSpecification(CircleService circleService){
        this.circleService = circleService;
    }

    @Override
    public boolean satisfies(Circle circle){
        return circleService.isUnitCircle(circle);
    }
}
