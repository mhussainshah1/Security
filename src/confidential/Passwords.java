package confidential;

import java.io.Console;
import java.util.Arrays;

public class Passwords {
    public static void main(String[] args) {
        Console console = System.console();
        char[] password = console.readPassword();
        System.out.println(password);
        Arrays.fill(password, 'x');
        System.out.println(password);
    }
}