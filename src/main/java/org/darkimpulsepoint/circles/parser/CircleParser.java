package org.darkimpulsepoint.circles.parser;

import java.util.Optional;

public interface CircleParser {
    Optional<double[]> parse(String line);
}
