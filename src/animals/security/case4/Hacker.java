package animals.security.case4;

public class Hacker {
    public static void main(String[] args) {

        var animal = new Animal();
        System.out.println(animal.getFavoriteFoods());
        animal.getFavoriteFoods().clear();
        System.out.println(animal.getFavoriteFoods());
    }
}
