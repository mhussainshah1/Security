package animals.security.case6;

import java.util.ArrayList;

public final class AnimalWithClonnable implements Cloneable {
    private final ArrayList<String> favoriteFoods;

    public AnimalWithClonnable() {
        this.favoriteFoods = new ArrayList<String>();
        this.favoriteFoods.add("Apples");
    }

    public AnimalWithClonnable(ArrayList<String> favoriteFoods) {
        if (favoriteFoods == null)
            throw new RuntimeException("favoriteFoods is required");
        this.favoriteFoods = favoriteFoods;
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

    public AnimalWithClonnable clone() {
        ArrayList<String> listClone = (ArrayList) favoriteFoods.clone();
        return new AnimalWithClonnable(listClone);
    }

    public static void main(String... args) throws Exception {
        var food = new ArrayList<String>();
        food.add("grass");
        var sheep = new AnimalWithClonnable(food);
        var clone =  sheep.clone();
        System.out.println(sheep == clone);
        System.out.println(sheep.favoriteFoods == clone.favoriteFoods);
    }
}
