package hu.bogich.adventofcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class AdventofcodeApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(AdventofcodeApplication.class, args);
        FileReader fr = new FileReader("src/main/resources/input_day1.txt");
        System.out.println("Final floor: " + getFloor(fr));
        fr.close();
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
    while ((count = fr.read()) != -1) {
        if((char) count == '('){
            return floor;
        }
    }
    }
}