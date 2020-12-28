package animals.security.case6;

import java.util.ArrayList;

public class Hacker {
    public static void main(String[] args) {
        var favorites = new ArrayList<String>();
        favorites.add("Apples");
        var animal = new Animal(favorites);
        System.out.println("Before: " + animal.getFavoriteFoodsCount());
        favorites.clear();
        System.out.println("After:  " +animal.getFavoriteFoodsCount());
    }
}
