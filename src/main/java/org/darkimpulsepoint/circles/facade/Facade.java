package org.darkimpulsepoint.circles.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.exception.CircleFileException;
import org.darkimpulsepoint.circles.factory.CircleFactory;
import org.darkimpulsepoint.circles.factory.impl.CircleFactoryImpl;
import org.darkimpulsepoint.circles.parser.impl.CircleParserImpl;
import org.darkimpulsepoint.circles.reader.impl.CircleFileReaderImpl;
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
    private final CircleParserImpl circleParser;
    private final CircleFileReaderImpl circleFileReader;
    private final CircleService circleService;
    private final Logger logger = LogManager.getLogger(Facade.class);;

    public Facade() {
        this.validator = new CircleValidatorImpl();
        this.factory = new CircleFactoryImpl(validator);
        this.circleParser = new CircleParserImpl();
        this.circleFileReader = new CircleFileReaderImpl();
        this.circleService = new CircleServiceImpl();
    }

    public void execute(String filePath) throws CircleFileException {
        List<String> circleStrings = circleFileReader.readFile(filePath);

        ArrayList<Circle> circles = new ArrayList<>();

        circleStrings.forEach(circleString -> {
            Optional<double[]> circleParameters = circleParser.parse(circleString);
            if (circleParameters.isPresent()){
                double[] parameters = circleParameters.get();
                Optional<Circle> circle = factory.create(parameters[0], parameters[1], parameters[2]);
                circle.ifPresent(circles::add);
            }
        });

        circles.forEach(logger::info);

        ArrayList<ArrayList<Circle>> lines =  circleService.findCirclesOnSameLine(circles);

        lines.forEach(line->logger.info("Group of circles on line:\n {}", line));


    }

}
