package animals.security.case5;

import java.util.ArrayList;

public class Hacker {
    public static void main(String[] args) {
        new Hacker().modifyNotSoImmutableObject();
    }

    void modifyNotSoImmutableObject() {
        var favorites = new ArrayList<String>();
        favorites.add("Apples");
        var animal1 = new Animal(favorites);
        System.out.println("Before: " + animal1.getFavoriteFoodsCount());
        favorites.clear();
        System.out.println("After:  " +animal1.getFavoriteFoodsCount());


    }
}