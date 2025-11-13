package hu.bogich.adventofcode.Year2015.runner;

import hu.bogich.adventofcode.Year2015.Service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@AllArgsConstructor
public class Day1 implements CommandLineRunner {
    final FileService fileService;
    final String inputFile = "src/main/resources/input_day1.txt";

    @Override
    public void run(String... args) {
        try {
            log.info("The instructions take Santa to floor {}.", String.valueOf(getFloor(inputFile)));
            log.info("Character position {} causes Santa to first enter the basement.", String.valueOf(getBasementPosition(inputFile)));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private int getFloor(String fileName) throws IOException {
        int floor = 0;
        String content = this.fileService.readFileByLine(fileName);
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '(') {
                floor++;
            } else if (content.charAt(i) == ')') {
                floor--;
            }
        }
        return floor;
    }

    private int getBasementPosition(String fileName) throws IOException {
        int floor = 0;
        int pos = 1;
        String content = this.fileService.readFileByLine(fileName);
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '(') {
                floor++;
            } else if (content.charAt(i) == ')') {
                floor--;
            }
            if (floor == -1) {
                return pos;
            }
            pos++;
        }
        return -1;
    }
}