package org.darkimpulsepoint.circles.factory.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.factory.CircleFactory;
import org.darkimpulsepoint.circles.validator.CircleValidator;

import java.util.Optional;

public class CircleFactoryImpl implements CircleFactory {
    private final CircleValidator validator;
    private final Logger logger;

    public CircleFactoryImpl(CircleValidator validator) {
        this.validator = validator;
        this.logger = LogManager.getLogger(CircleFactoryImpl.class);
    }

    @Override
    public Optional<Circle> create(double x, double y, double radius) {
        if (validator.validateRadius(radius)
            && validator.validateCoordinateX(x)
            && validator.validateCoordinateY(y)
        ) {
            Circle circle = new Circle(x, y, radius);
            logger.info("New circle: {}", circle);
            return Optional.of(circle);
        } else {
            logger.warn("No circle created");
            return Optional.empty();
        }

    }
}