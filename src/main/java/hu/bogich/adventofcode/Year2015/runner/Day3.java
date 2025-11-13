package hu.bogich.adventofcode.Year2015.runner;

import hu.bogich.adventofcode.Year2015.Service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Component
public class Day3 implements CommandLineRunner {
    final FileService fileService;
    final String inputFile = "src/main/resources/2015_input3.txt";

    @Override
    public void run(String... args) throws Exception {
        log.info("{} houses receive at least one present.", String.valueOf(countHouses()));
    }

    public int countHouses() throws IOException {
        int x = 0;
        int y = 0;
        String content = fileService.readFileByLine(inputFile);
        Map<String, Integer> houses = new HashMap<>();
        houses.put(createCoordinates(x, y), 1);
        for (int i = 0; i < content.length(); i++) {
            switch (content.charAt(i)) {
                case '^':
                    x++;
                    break;
                case 'v':
                    x--;
                    break;
                case '<':
                    y--;
                    break;
                case '>':
                    y++;
                    break;
            }
            String coordinates = createCoordinates(x, y);
            if (houses.containsKey(coordinates)) {
                houses.put(coordinates, houses.get(coordinates) + 1);
            } else {
                houses.put(coordinates, 1);
            }
        }
        return houses.size();
    }

    private String createCoordinates(int x, int y) {
        return String.valueOf(x) + "," + String.valueOf(y);
    }


}