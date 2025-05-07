package org.darkimpulsepoint.circles.specification.impl;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.service.CircleService;
import org.darkimpulsepoint.circles.specification.Specification;

public class PerimeterRangeCircleSpecification implements Specification<Circle> {
    private double minRange;
    private double maxRange;
    private CircleService circleService;

    public PerimeterRangeCircleSpecification(double minRange, double maxRange, CircleService circleService){
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    @Override
    public boolean satisfies(Circle circle){
        double area =  circleService.findCirclePerimeter(circle);
        return area >= minRange && area <= maxRange;
    }
}
