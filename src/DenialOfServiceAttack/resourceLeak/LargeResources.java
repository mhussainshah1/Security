package DenialOfServiceAttack.resourceLeak;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LargeResources {
    public void transform(Path in, Path out) throws IOException {
        var list = Files.readAllLines(in);
        list.removeIf(s -> s.trim().isBlank());
        Files.write(out, list);
    }
}
