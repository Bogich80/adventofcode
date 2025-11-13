package hu.bogich.adventofcode.Year2015.runner;

import hu.bogich.adventofcode.Year2015.Service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Component
public class Day4 implements CommandLineRunner {
    final FileService fileService;
    final String inputFile = "src/main/resources/2015_input4.txt";

    @Override
    public void run(String... args) throws Exception {

    }

}