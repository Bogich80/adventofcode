package hu.bogich.adventofcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class AdventofcodeApplication {
    private static int totalPaper = 0;

    public static void main(String[] args) throws IOException {

        SpringApplication.run(AdventofcodeApplication.class, args);
        FileReader fr = new FileReader("src/main/resources/input_day1.txt");
        System.out.println("Final floor: " + getFloor(fr));
        fr.close();
        fr = new FileReader("src/main/resources/input_day1.txt");
        System.out.println("Basement position: " + getBasementPosition(fr));
        fr.close();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/2015_input2.txt"));
        String sor;
        while ((sor = br.readLine()) != null) {
            totalPaper += calcTotalPapers(sor);
        }
        br.close();
        System.out.println("Total paper: " + totalPaper);
    }

    private static int getFloor(FileReader fr) throws IOException {
        int count;
        int floor = 0;

        while ((count = fr.read()) != -1) {
            if ((char) count == '(') {
                floor++;
            } else if ((char) count == ')') {
                floor--;
            }
        }
        return floor;
    }

    private static int getBasementPosition(FileReader fr) throws IOException {
        int count;
        int floor = 0;
        int pos = 1;
        while ((count = fr.read()) != -1) {
            if ((char) count == '(') {
                floor++;
            } else if ((char) count == ')') {
                floor--;
            }

            if (floor == -1) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

    public static int calcTotalPapers(String dimensions) {
        String[] dimensionArray = dimensions.split("x");
        int[] dimensionNumbers = Arrays.stream(dimensionArray).mapToInt(Integer::parseInt).sorted().toArray();
        return 2 * (dimensionNumbers[0] * dimensionNumbers[1]) + 2 * (dimensionNumbers[1] * dimensionNumbers[2]) +
                2 * (dimensionNumbers[0] * dimensionNumbers[2]) + dimensionNumbers[0] * dimensionNumbers[1];
    }
}