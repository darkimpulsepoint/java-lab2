package org.darkimpulsepoint.circles.service;

import org.darkimpulsepoint.circles.entity.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CircleService {

    Optional<Circle> findCircleWithMaxArea(List<Circle> circles);

    Optional<Circle> findCircleWithMinArea(List<Circle> circles);

    Optional<Circle> findCircleWithMaxPerimeter(List<Circle> circles);

    Optional<Circle> findCircleWithMinPerimeter(List<Circle> circles);

    ArrayList<ArrayList<Circle>> findCirclesOnSameLine(List<Circle> circles);

    double findCircleArea(Circle circle);

    double findCirclePerimeter(Circle circle);

    boolean isUnitCircle(Circle circle);

    boolean isLargeCircle(Circle circle);



}