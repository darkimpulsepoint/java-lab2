package org.darkimpulsepoint.circles.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.darkimpulsepoint.circles.comparator.CircleComparator;
import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.repository.CircleRepository;
import org.darkimpulsepoint.circles.specification.Specification;
import java.util.ArrayList;
import java.util.List;

public class CircleRepositoryImpl implements CircleRepository {
    private static final Logger logger = LogManager.getLogger(CircleRepositoryImpl.class);
    private final List<Circle> circles = new ArrayList<>();

    @Override
    public void add(Circle circle) {
        logger.info("Adding circle: {}", circle);
        circles.add(circle);
        logger.info("Circle added successfully. Total circles: {}", circles.size());
    }

    @Override
    public List<Circle> sort(CircleComparator comparator) {
        logger.info("Sorting circles using comparator: " + comparator.getClass().getName());
        var sorted = new ArrayList<>(circles);
        sorted.sort(comparator);
        return sorted;
    }

    @Override
    public List<Circle> query(Specification<Circle> specification) {
        return circles.stream().filter(specification::isSatisfiedBy).toList();
    }


    @Override
    public List<Circle> all() {
        logger.info("Retrieving all circles. Total circles: {}", circles.size());
        return new ArrayList<>(this.circles);
    }
}