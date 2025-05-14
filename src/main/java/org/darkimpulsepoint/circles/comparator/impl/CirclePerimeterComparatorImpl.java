package org.darkimpulsepoint.circles.comparator.impl;

import org.darkimpulsepoint.circles.comparator.CircleComparator;
import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.pool.Warehouse;

public class CirclePerimeterComparatorImpl implements CircleComparator {
    private final Warehouse warehouse = Warehouse.getInstance();

    @Override
    public int compare(Circle o1, Circle o2) {
        double perimeter1 = warehouse.getParameters(o1).getPerimeter();
        double perimeter2 = warehouse.getParameters(o2).getPerimeter();

        return Double.compare(perimeter1, perimeter2);
    }
}
