package hu.bogich.adventofcode.Year2015.runner;

import hu.bogich.adventofcode.Year2015.Service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Slf4j
@AllArgsConstructor
@Component
public class Day4 implements CommandLineRunner {
    final FileService fileService;
    final String inputFile = "src/main/resources/2015_input4.txt";

    @Override
    public void run(String... args) throws Exception {
        log.info(String.valueOf(getMinHashInt()));
    }

    public int getMinHashInt() throws IOException, NoSuchAlgorithmException {
        String input = fileService.readFileByLine(inputFile).trim();
        StringBuilder sb = null;
        int additionalNumber = 0;
        while (true) {
            if (sb != null) {
                if (sb.substring(0, 5).equals("00000")) break;
            }
            additionalNumber++;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest((input + additionalNumber).getBytes());
            sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

        }
        return additionalNumber;
    }
}