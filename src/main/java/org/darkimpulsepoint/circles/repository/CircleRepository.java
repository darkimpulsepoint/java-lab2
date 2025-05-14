package org.darkimpulsepoint.circles.repository;

import org.darkimpulsepoint.circles.comparator.CircleComparator;
import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.specification.Specification;

import java.util.List;

public interface CircleRepository {
    void add(Circle circle);
    List<Circle> sort(CircleComparator comparator);
    List<Circle> query(Specification<Circle> specification);
    List<Circle> all();
}