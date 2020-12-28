package animals.security.case6;

/**
 * 1. Mark the class as final.
 * 2. Mark all the instance variables private.
 * 3. Don’t define any setter methods and make fields final.
 * 4. Don’t allow referenced mutable objects to be modified.
 * 5. Use a constructor to set all properties of the object, making a copy if needed.
 */

import java.util.ArrayList;

public final class Animal {

    private final ArrayList<String> favoriteFoods;

    public Animal() {
        this.favoriteFoods = new ArrayList<String>();
        this.favoriteFoods.add("Apples");
    }

    public Animal(ArrayList<String> favoriteFoods) {
        if (favoriteFoods == null)
            throw new RuntimeException("favoriteFoods is required");
//        this.favoriteFoods = favoriteFoods;
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public ArrayList<String> getFavoriteFoods() {
        return new ArrayList<String>(this.favoriteFoods);
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFoodsElement(int index) {
        return favoriteFoods.get(index);
    }
}
