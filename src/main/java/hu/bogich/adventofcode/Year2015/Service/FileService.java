package hu.bogich.adventofcode.Year2015.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FileService {
    public String readFileByLine(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String row;
            while ((row = br.readLine()) != null) {
                sb.append(row).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String readFileByChar(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                sb.append((char) c);
            }
        }

        return sb.toString();
    }
}

