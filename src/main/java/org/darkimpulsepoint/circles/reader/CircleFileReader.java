package org.darkimpulsepoint.circles.reader;

import org.darkimpulsepoint.circles.exception.FileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CircleFileReader {
    public List<String> readFile(String path) throws FileException {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.toList();
        } catch (IOException e) {
            throw new FileException("Error while reading file %s".format(path));
        }
    }
}
