package by.itech.app.controller.service.impl;

import by.itech.app.controller.service.MainService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainServiceImpl implements MainService {
    private static final String RESOURCE_NAME = "input.txt";

    @Override
    public List<String> getListNumber() {
        Stream<String> lines = null;
        List<String> collect = null;

        try {
            Path path = Paths.get((Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource(RESOURCE_NAME)))
                    .toURI());

            lines = Files.lines(path);
            collect = lines.collect(Collectors.toList());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        } finally {
            if (lines != null) {
                lines.close();
            }
        }
        return collect;
    }
}
