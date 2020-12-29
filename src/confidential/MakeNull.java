package confidential;

import java.time.LocalDate;

public class MakeNull {
    public static void main(String[] args) {
        LocalDate dateOfBirth = getDateOfBirth();
        // use date of birth
        dateOfBirth = null;
    }

    private static LocalDate getDateOfBirth() {
        return LocalDate.now();
    }
}
