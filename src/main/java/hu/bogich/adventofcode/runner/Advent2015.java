package hu.bogich.adventofcode.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Slf4j
@Component
public class Advent2015 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("=== Advent of Code 2015 ===");
    }
}
