package hu.bogich.adventofcode.Year2015.runner;

import hu.bogich.adventofcode.Year2015.Service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Slf4j
@AllArgsConstructor
public class Day2 implements CommandLineRunner {
    final FileService fileService;
    final String inputFile = "src/main/resources/2015_input2.txt";

    @Override
    public void run(String... args) {
        try {
            log.info("They should order {} square feet of wrapping paper.", calcTotalPapers(inputFile));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public int calcTotalPapers(String fileName) throws IOException {
        String[] content = fileService.readFileByLine(fileName).split("\\R");
        int totalPapers = 0;
        for (String row : content) {
            String[] dimensionArray = row.split("x");
            int[] dimensionNumbers = Arrays.stream(dimensionArray).mapToInt(Integer::parseInt).sorted().toArray();
            totalPapers += 2 * (dimensionNumbers[0] * dimensionNumbers[1]) + 2 * (dimensionNumbers[1] * dimensionNumbers[2]) +
                    2 * (dimensionNumbers[0] * dimensionNumbers[2]) + dimensionNumbers[0] * dimensionNumbers[1];
        }
        return totalPapers;
    }

}