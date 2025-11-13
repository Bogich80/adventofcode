package hu.bogich.adventofcode.Year2015.runner;

import hu.bogich.adventofcode.Year2015.Service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

@Slf4j
@AllArgsConstructor
public class Day1 implements CommandLineRunner {
    final FileService fileService;
    final String inputFile = "src/main/resources/input_day1.txt";

    @Override
    public void run(String... args) {
        String content;
        try {
            content = fileService.readFileByLine(inputFile);

        } catch (IOException e) {
            log.error(e.getMessage());
            return;
        }
        log.info("The instructions take Santa to floor {}.", getFloor(content));
        log.info("Character position {} causes Santa to first enter the basement.", getBasementPosition(content));
    }

    private int getFloor(String content) {
        int floor = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '(') {
                floor++;
            } else if (content.charAt(i) == ')') {
                floor--;
            }
        }
        return floor;
    }

    private int getBasementPosition(String content) {
        int floor = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '(') {
                floor++;
            } else if (content.charAt(i) == ')') {
                floor--;
            }
            if (floor == -1) {
                return i + 1;
            }
        }
        return -1;
    }
}