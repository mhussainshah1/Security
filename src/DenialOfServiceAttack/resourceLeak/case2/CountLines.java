package DenialOfServiceAttack.resourceLeak.case2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountLines {
    public long countLines(Path path) throws IOException {
        try (var stream = Files.lines(path)) {
            return stream.count();
        }
    }
}
