package org.darkimpulsepoint.circles;

import org.darkimpulsepoint.circles.exception.FileException;
import org.darkimpulsepoint.circles.facade.Facade;

public class Main{
    public static void main(String[] args) throws FileException {
        Facade facade = new Facade();
        facade.execute();
    }
}