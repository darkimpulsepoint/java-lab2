package org.darkimpulsepoint.circles.reader;

import org.darkimpulsepoint.circles.exception.CircleFileException;

import java.util.List;

public interface CircleFileReader {
    public List<String> readFile(String path) throws CircleFileException;
}
