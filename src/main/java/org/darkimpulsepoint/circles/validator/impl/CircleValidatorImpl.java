package org.darkimpulsepoint.circles.validator.impl;

import org.darkimpulsepoint.circles.validator.CircleValidator;

public class CircleValidatorImpl implements CircleValidator {
    @Override
    public boolean validateRadius(double radius) {
        return radius > 0 ;
    }

    @Override
    public boolean validateCoordinateX(double x){
        return x > -5000 && x < 5000;
    }

    public boolean validateCoordinateY(double y){
        return y > -5000 && y < 5000;
    }
}
