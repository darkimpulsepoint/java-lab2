package org.darkimpulsepoint.circles.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.repository.CircleRepository;
import org.darkimpulsepoint.circles.service.CircleService;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<Circle> sortByRadius() {
        logger.info("Sorting circles by radius");
        var sorted = new ArrayList<>(circles);
        sorted.sort(Comparator.comparingDouble(Circle::getRadius));
        logger.info("Sorted {} circles by radius", sorted.size());
        return sorted;
    }

    @Override
    public List<Circle> sortByArea(CircleService circleService) {
        logger.info("Sorting circles by area");
        var sorted = new ArrayList<>(circles);
        sorted.sort(Comparator.comparingDouble(circleService::findCircleArea));
        logger.info("Sorted {} circles by area", sorted.size());
        return sorted;
    }

    @Override
    public List<Circle> sortByPerimeter(CircleService circleService) {
        logger.info("Sorting circles by perimeter");
        var sorted = new ArrayList<>(circles);
        sorted.sort(Comparator.comparingDouble(circleService::findCirclePerimeter));
        logger.info("Sorted {} circles by perimeter", sorted.size());
        return sorted;
    }

    @Override
    public List<Circle> sortByXCoordinate() {
        logger.info("Sorting circles by X coordinate");
        var sorted = new ArrayList<>(circles);
        sorted.sort(Comparator.comparingDouble(Circle::getX));
        logger.info("Sorted {} circles by X coordinate", sorted.size());
        return sorted;
    }

    @Override
    public List<Circle> sortByYCoordinate() {
        logger.info("Sorting circles by Y coordinate");
        var sorted = new ArrayList<>(circles);
        sorted.sort(Comparator.comparingDouble(Circle::getY));
        logger.info("Sorted {} circles by Y coordinate", sorted.size());
        return sorted;
    }

    @Override
    public List<Circle> all() {
        logger.info("Retrieving all circles. Total circles: {}", circles.size());
        return new ArrayList<>(this.circles);
    }
}