package org.darkimpulsepoint.circles.comparator.impl;

import org.darkimpulsepoint.circles.comparator.CircleComparator;
import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.pool.Warehouse;

public class CircleAreaComparatorImpl implements CircleComparator {
    private final Warehouse warehouse = Warehouse.getInstance();

    @Override
    public int compare(Circle o1, Circle o2) {
        double area1 = warehouse.getParameters(o1).getArea();
        double area2 = warehouse.getParameters(o2).getArea();

        return Double.compare(area1, area2);
    }
}
