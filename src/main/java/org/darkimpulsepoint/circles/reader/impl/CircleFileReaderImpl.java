package org.darkimpulsepoint.circles.reader.impl;

import org.darkimpulsepoint.circles.exception.CircleFileException;
import org.darkimpulsepoint.circles.reader.CircleFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CircleFileReaderImpl implements CircleFileReader {
    public List<String> readFile(String path) throws CircleFileException {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.toList();
        } catch (IOException e) {
            throw new CircleFileException("Error while reading file %s".format(path));
        }
    }
}