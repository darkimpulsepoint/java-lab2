package org.darkimpulsepoint.circles.repository;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.service.CircleService;

import java.util.List;

public interface CircleRepository {
    void add(Circle circle);
    List<Circle> sortByRadius();
    List<Circle> sortByArea(CircleService circleService);
    List<Circle> sortByPerimeter(CircleService circleService);
    List<Circle> sortByXCoordinate();
    List<Circle> sortByYCoordinate();
    List<Circle> all();
}