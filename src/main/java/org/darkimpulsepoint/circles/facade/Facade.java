package org.darkimpulsepoint.circles.facade;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.exception.FileException;
import org.darkimpulsepoint.circles.factory.CircleFactory;
import org.darkimpulsepoint.circles.factory.impl.CircleFactoryImpl;
import org.darkimpulsepoint.circles.parser.CircleParser;
import org.darkimpulsepoint.circles.reader.CircleFileReader;
import org.darkimpulsepoint.circles.service.CircleService;
import org.darkimpulsepoint.circles.service.impl.CircleServiceImpl;
import org.darkimpulsepoint.circles.validator.CircleValidator;
import org.darkimpulsepoint.circles.validator.impl.CircleValidatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Facade {
    private final CircleValidator validator;
    private final CircleFactory factory;
    private final CircleParser circleParser;
    private final CircleFileReader circleFileReader;
    private final CircleService circleService;
    private final Logger logger;

    public Facade() {
        this.validator = new CircleValidatorImpl();
        this.factory = new CircleFactoryImpl(validator);
        this.circleParser = new CircleParser(factory);
        this.circleFileReader = new CircleFileReader();
        this.logger = LogManager.getLogger(Facade.class);
        this.circleService = new CircleServiceImpl();
    }

    public void execute() throws FileException {
        String file = "/home/alexus/IdeaProjects/laba2/src/main/resources/circles.txt";
        List<String> circleStrings = circleFileReader.readFile(file);

        ArrayList<Circle> circles = new ArrayList<>();

        circleStrings.forEach(circleString -> {
            Optional<Circle> circle = circleParser.parse(circleString);
            circle.ifPresent(circles::add);
        });

        circles.forEach(logger::info);

        ArrayList<ArrayList<Circle>> lines =  circleService.findCirclesOnSameLine(circles);

        lines.forEach(line->logger.info("Group of circles on line:\n {}", line));


    }

}
