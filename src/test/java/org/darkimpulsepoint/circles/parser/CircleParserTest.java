package org.darkimpulsepoint.circles.parser;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.factory.CircleFactory;
import org.darkimpulsepoint.circles.factory.impl.CircleFactoryImpl;
import org.darkimpulsepoint.circles.validator.impl.CircleValidatorImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class CircleParserTest {
    private CircleFactory factory;
    private CircleParser parser;

    @BeforeClass
    public void setup() {
        factory = new CircleFactoryImpl(new CircleValidatorImpl());
        parser = new CircleParser(factory);
    }

    @Test
    public void testValidInput() {
        Optional<Circle> result = parser.parse("1.0 2.0 3.0");
        assertTrue(result.isPresent());
    }

    @Test
    public void testInvalidFormat() {
        Optional<Circle> result = parser.parse("1.0 2.0");
        assertFalse(result.isPresent());
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testInvalidNumbers() {
        parser.parse("abc def ghi");
    }

    @Test
    public void testNegativeRadius() {
        Optional<Circle> result = parser.parse("1.0 2.0 -3.0");
        assertFalse(result.isPresent());
    }

    @Test
    public void testZeroRadius() {
        Optional<Circle> result = parser.parse("1.0 2.0 0.0");
        assertFalse(result.isPresent());
    }

    @Test
    public void testWhitespaceHandling() {
        Optional<Circle> result = parser.parse(" 1.0  2.0  3.0 ");
        assertTrue(result.isPresent());
    }

    @Test
    public void testExtraArguments() {
        Optional<Circle> result = parser.parse("1.0 2.0 3.0 extra");
        assertFalse(result.isPresent());
    }

    @Test
    public void testLargeValues() {
        Optional<Circle> result = parser.parse("1.0 2.0 1e10");
        assertTrue(result.isPresent());
        assertEquals(result.get().getRadius(), 1e10);
    }

    @Test
    public void testNegativeCoordinates() {
        Optional<Circle> result = parser.parse("-1.0 -2.0 3.0");
        assertTrue(result.isPresent());
    }
}
