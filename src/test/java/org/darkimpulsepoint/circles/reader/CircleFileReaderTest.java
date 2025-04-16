package org.darkimpulsepoint.circles.reader;

import org.darkimpulsepoint.circles.exception.FileException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CircleFileReaderTest {
    private CircleFileReader reader;

    @BeforeClass
    public void setup() {
        reader = new CircleFileReader();
    }

    @Test
    public void testValidFile() throws FileException {
        List<String> lines = reader.readFile("src/test/resources/valid.txt");
        assertFalse(lines.isEmpty());
    }

    @Test(expectedExceptions = FileException.class)
    public void testNonexistentFile() throws FileException {
        reader.readFile("nonexistent.txt");
    }

    @Test
    public void testEmptyFile() throws FileException {
        List<String> lines = reader.readFile("src/test/resources/empty.txt");
        assertTrue(lines.isEmpty());
    }
}