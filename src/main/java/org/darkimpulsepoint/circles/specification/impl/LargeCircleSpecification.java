package org.darkimpulsepoint.circles.specification.impl;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.service.CircleService;
import org.darkimpulsepoint.circles.specification.Specification;

public class LargeCircleSpecification implements Specification<Circle> {
    private CircleService circleService;

    public LargeCircleSpecification(CircleService circleService){
        this.circleService = circleService;
    }

    @Override
    public boolean satisfies(Circle circle){
        return circleService.isLargeCircle(circle);
    }
}
