package org.darkimpulsepoint.circles.parser;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.factory.CircleFactory;

import java.util.Optional;

public class CircleParser {
    private CircleFactory circleFactory;

    public CircleParser(CircleFactory circleFactory) {
        this.circleFactory = circleFactory;
    }

    public Optional<Circle> parse(String line) {
        String[] parts = line.trim().split("\\s+");

        if (parts.length != 3) {
            return Optional.empty();
        }

        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
        double radius = Double.parseDouble(parts[2]);

        return this.circleFactory.create(x, y, radius);

    }
}
