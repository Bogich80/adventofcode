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
        log.info("{} houses receive at least one present.", countHouses(false));
        log.info("{} houses receive at least one present if robot helps.", countHouses(true));
    }

    public int countHouses(Boolean withRobot) throws IOException {
        int x = 0;
        int y = 0;
        int robotX = 0;
        int robotY = 0;
        String content = fileService.readFileByLine(inputFile);
        Map<String, Integer> houses = new HashMap<>();
        houses.put(createCoordinates(x, y), 1);
        for (int i = 0; i < content.length(); i++) {
            boolean isRobot = (i + 1) % 2 == 0;
            switch (content.charAt(i)) {
                case '^':
                    if (!withRobot) {
                        x++;
                    } else {
                        if (isRobot) {
                            robotX++;
                        } else {
                            x++;
                        }
                    }
                    break;
                case 'v':
                    if (!withRobot) {
                        x--;
                    } else {
                        if (isRobot) {
                            robotX--;
                        } else {
                            x--;
                        }
                    }
                    break;
                case '<':
                    if (!withRobot) {
                        y--;
                    } else {
                        if (isRobot) {
                            robotY--;
                        } else {
                            y--;
                        }
                    }
                    break;
                case '>':
                    if (!withRobot) {
                        y++;
                    } else {
                        if (isRobot) {
                            robotY++;
                        } else {
                            y++;
                        }
                    }
                    break;
            }
            String coordinates = null;
            if (!withRobot) {
                coordinates = createCoordinates(x, y);
            } else {
                if (isRobot) {
                    coordinates = createCoordinates(robotX, robotY);
                } else {
                    coordinates = createCoordinates(x, y);
                }
            }

            if (houses.containsKey(coordinates)) {
                houses.put(coordinates, houses.get(coordinates) + 1);
            } else {
                houses.put(coordinates, 1);
            }
        }
        return houses.size();
    }

    private String createCoordinates(int x, int y) {
        return x + "," + y;
    }

}