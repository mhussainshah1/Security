package animals.security.case1;

public class Hacker {

    public static void main(String[] args) {
        var harry = new ComboLocks();
        System.out.println(harry.combos);
        harry.combos.clear();
        System.out.println(harry.combos);
    }
}
