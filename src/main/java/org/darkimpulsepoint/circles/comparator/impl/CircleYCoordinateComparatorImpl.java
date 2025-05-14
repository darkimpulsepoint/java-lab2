package org.darkimpulsepoint.circles.comparator.impl;

import org.darkimpulsepoint.circles.comparator.CircleComparator;
import org.darkimpulsepoint.circles.entity.Circle;

public class CircleYCoordinateComparatorImpl implements CircleComparator {
    @Override
    public int compare(Circle o1, Circle o2) {
        return Double.compare(o1.getY(), o2.getY());
    }
}
