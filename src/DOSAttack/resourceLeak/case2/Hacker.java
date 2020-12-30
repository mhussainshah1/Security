package DOSAttack.resourceLeak.case2;

import java.io.IOException;
import java.nio.file.Path;

public class Hacker {
    public static void main(String[] args) throws IOException {
        var countLines = new CountLines();
        while (true){
            countLines.countLines(Path.of("src/DOSAttack/resourceLeak/Hacker.txt"));
        }
    }
}
