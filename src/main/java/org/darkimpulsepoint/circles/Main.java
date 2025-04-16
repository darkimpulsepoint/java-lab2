package org.darkimpulsepoint.circles;

import org.darkimpulsepoint.circles.exception.CircleFileException;
import org.darkimpulsepoint.circles.facade.Facade;

public class Main{
    public static void main(String[] args) throws CircleFileException {
        String circleFilePath = "data/circles/circles.txt";
        Facade facade = new Facade();
        facade.execute(circleFilePath);
    }
}