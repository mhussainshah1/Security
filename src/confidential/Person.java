package confidential;

import java.time.LocalDate;

public class Person {
    LocalDate dateOfBirth;

    private LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static void main(String[] args) {
        var obj = new Person();
        LocalDate dateOfBirth = obj.getDateOfBirth();
        // use date of birth
        dateOfBirth = null;
    }
}