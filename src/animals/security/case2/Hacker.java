package animals.security.case2;

public class Hacker extends ComboLocks{
    public boolean isComboValid(String animal, String combo) {
        var valid = super.isComboValid(animal, combo);
        if (valid) {
            // email the password to Hacker Harry
        }
        return valid;
    }

    public static void main(String[] args) {
        var harry = new ComboLocks();
        //get password
        System.out.println(harry.isComboValid("grasshopper", "123456"));

        //openlock by ComboLocks object
        GrasshopperCage.openLock(harry,"123456");
    }
}
