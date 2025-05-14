package org.darkimpulsepoint.circles.specification.impl;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.pool.Warehouse;
import org.darkimpulsepoint.circles.service.CircleService;
import org.darkimpulsepoint.circles.specification.Specification;

public class PerimeterRangeCircleSpecification implements Specification<Circle> {
    private double minRange;
    private double maxRange;
    private static final Warehouse warehouse = Warehouse.getInstance();


    public PerimeterRangeCircleSpecification(double minRange, double maxRange){
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    @Override
    public boolean isSatisfiedBy(Circle circle){
        double perimeter = warehouse.getParameters(circle).getPerimeter();
        return perimeter >= minRange && perimeter <= maxRange;
    }
}
