package org.darkimpulsepoint.circles.factory;

import org.darkimpulsepoint.circles.entity.Circle;

import java.util.Optional;

public interface CircleFactory {
    Optional<Circle> create(double x, double y, double radius);
}