package org.darkimpulsepoint.circles.comparator.impl;

import org.darkimpulsepoint.circles.comparator.CircleComparator;
import org.darkimpulsepoint.circles.entity.Circle;

public class CircleXCoordinateComparatorImpl implements CircleComparator {
    @Override
    public int compare(Circle o1, Circle o2) {
        return Double.compare(o1.getX(), o2.getX());
    }
}
