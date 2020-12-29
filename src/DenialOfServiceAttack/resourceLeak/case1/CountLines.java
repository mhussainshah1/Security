package DenialOfServiceAttack.resourceLeak.case1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountLines {
    public long countLines(Path path) throws IOException {
        return Files.lines(path).count();
    }
}
