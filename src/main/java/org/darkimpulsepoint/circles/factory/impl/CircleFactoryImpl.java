package org.darkimpulsepoint.circles.factory.impl;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.factory.CircleFactory;
import org.darkimpulsepoint.circles.validator.CircleValidator;

import java.util.Optional;

public class CircleFactoryImpl implements CircleFactory {
    private final CircleValidator validator;

    public CircleFactoryImpl(CircleValidator validator) {
        this.validator = validator;
    }

    @Override
    public Optional<Circle> create(double x, double y, double radius) {
        if (validator.validateRadius(radius)
            && validator.validateCoordinateX(x)
            && validator.validateCoordinateY(y)
        ) {
            Circle circle = new Circle(x, y, radius);
            return Optional.of(circle);
        } else {
            return Optional.empty();
        }

    }
}