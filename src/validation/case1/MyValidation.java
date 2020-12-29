package validation.case1;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MyValidation {
    public static void main(String[] args) throws IOException {
        Console console = System.console();
        String dirName = console.readLine();
        Path path = Paths.get("c:/data/diets/" + dirName);
        try (Stream<Path> stream = Files.walk(path)) {
            stream.filter(p -> p.toString().endsWith(".txt"))
                    .forEach(System.out::println);
        }
    }
}
